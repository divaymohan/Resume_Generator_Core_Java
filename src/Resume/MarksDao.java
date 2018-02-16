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

import Resume.MarksProgram;
import Resume.Marks;
public class MarksDao extends MDao
{	
	
	PreparedStatement searchStatement;
	PreparedStatement updateStatement;
	PreparedStatement deleteStatement;
	PreparedStatement selectStatement;
	ResultSet resultset;
	public MarksDao()throws Exception
	{			
		this.searchStatement = this.connection.prepareStatement("select * from marks where ID = ?");
		this.updateStatement = this.connection.prepareStatement("update marks set ResultDate=?,Score=? where ID=?");
		this.deleteStatement = this.connection.prepareStatement("delete from marks where ID=?");
		this.selectStatement = this.connection.prepareStatement("select * from marks");
	}
	
	public ResultSet search(MarksDetail mark )throws Exception
	{
		this.searchStatement.setInt(1, mark.getID());
		//String sql1 = "SELECT * FROM Students WHERE ID=?";
		//Statement s=connection.prepareStatement(sql1);
		//s.setInt(1,student.);
		
		resultset=searchStatement.executeQuery();
		while(resultset.next()){
			System.out.println( resultset.getInt(1) + " " + resultset.getInt(2) + " " + resultset.getInt(3)+ " " + resultset.getDate(4)+ " " + resultset.getInt(5));
			
			
		}
		return resultset;
				
				
	}
	public int update( MarksDetail mark )throws Exception
	{
		
		//this.updateStatement.setInt(1, extracurricular.getStudentId());
		this.updateStatement.setString(1,mark.getResultDate());
		this.updateStatement.setInt(2, mark.getScore());
		this.updateStatement.setInt(2, mark.getID());
		
		return this.updateStatement.executeUpdate();
	}
	public int delete( MarksDetail mark )throws Exception
	{
		this.deleteStatement.setInt(1,mark.getID());
		return this.deleteStatement.executeUpdate();
	}
	/*public List<MarksDetail> getMarkList()throws Exception
	{
		List<MarksDetail> MarkList = new ArrayList<MarksDetail>();		
		try(ResultSet rs = this.selectStatement.executeQuery();)
		{
			while( rs.next())
			{
				//MarksDetail address = new MarksDetail(rs.getInt(1),rs.getInt(2),rs.getInt(3), rs.getString(4),rs.getInt(5));
				//MarkList.add(address);
			}
		}
	 return Marklist;
	}*/
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
