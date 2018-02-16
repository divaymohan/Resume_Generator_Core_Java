package Resume;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Resume.AddressProgram;
import Resume.Address;
public class AddressDao extends ADao
{	
	
	PreparedStatement searchStatement;
	PreparedStatement updateStatement;
	PreparedStatement deleteStatement;
	PreparedStatement selectStatement;
	ResultSet resultset;
	public AddressDao()throws Exception
	{			
		this.searchStatement = this.connection.prepareStatement("select * from address where ID = ?");
		this.updateStatement = this.connection.prepareStatement("update address set City=?,State=?, Country=?,Pin=?,Line1 = ?,Line2 = ? where ID=?");
		this.deleteStatement = this.connection.prepareStatement("delete from address where ID=?");
		this.selectStatement = this.connection.prepareStatement("select * from address");
	}
	
	/*public ResultSet search(Addr address )throws Exception
	{
		this.searchStatement.setInt(1, address.getID());
		//String sql1 = "SELECT * FROM Students WHERE ID=?";
		//Statement s=connection.prepareStatement(sql1);
		//s.setInt(1,student.);
		
		resultset=searchStatement.executeQuery();
		while(resultset.next()){
			System.out.println( resultset.getInt(1) + " " + resultset.getString(2) + " " + resultset.getString(3)+ " " + resultset.getString(4)+ " " + resultset.getString(5)+ " " + resultset.getString(6)+ " " + resultset.getString(7)+ " " + resultset.getString(8)+ " " + resultset.getString(9)+ " " + resultset.getString(10));
			
		}
		return resultset;
				
				
	}*/
	public int update( Addr address )throws Exception
	{
		
		this.updateStatement.setString(1, address.getCity());
		this.updateStatement.setString(2, address.getState());
		this.updateStatement.setString(3, address.getCountry());
		this.updateStatement.setInt(4, address.getPin());
		this.updateStatement.setString(5, address.getLine1());
		this.updateStatement.setString(6, address.getLine2());
		this.updateStatement.setInt(7, address.getID());
				
		return this.updateStatement.executeUpdate();
	}
	public int delete( Addr address )throws Exception
	{
		this.deleteStatement.setInt(1,address.getID());
		return this.deleteStatement.executeUpdate();
	}
	public List<Addr> getAddressList()throws Exception
	{
		List<Addr> AddressList = new ArrayList<Addr>();		
		try(ResultSet rs = this.selectStatement.executeQuery();)
		{
			while( rs.next())
			{
				Addr address = new Addr(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5), rs.getString(6), rs.getString(7));
				AddressList.add(address);
			}
		}
		return AddressList;
	}
	@Override
	public void close() throws IOException
	{
		try
		{
			this.searchStatement.close();
			this.updateStatement.close();
			this.deleteStatement.close();
			this.selectStatement.close();
			super.close();
		} 
		catch (SQLException e)
		{
			throw new IOException(e);
		}
	}
}
