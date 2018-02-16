package Resume;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import Resume.UserProgram;
import Resume.UserLogin;
public class UserDAO extends UDao
{	
	PreparedStatement insertStatement;
	//PreparedStatement updateStatement;
	//PreparedStatement deleteStatement;
	//PreparedStatement selectStatement;
	PreparedStatement checkStatement;
	public UserDAO()throws Exception
	{			
		this.insertStatement = this.connection.prepareStatement("insert into users(Email,Password,Role) values(?,?,?)");
		//this.updateStatement = this.connection.prepareStatement("update users set Email=?,Password=?, Role=? where ID=?");
		//this.deleteStatement = this.connection.prepareStatement("delete from users where ID=?");
		//this.selectStatement = this.connection.prepareStatement("select * from users");
		this.checkStatement = this.connection.prepareStatement("SELECT Email,Password FROM Users WHERE Email=?");
	}
	
	public int RegisterUser(Login login )throws Exception
	{
		this.insertStatement.setString(1, login.getUsername());
		this.insertStatement.setString(2, login.getPassword());
		this.insertStatement.setString(3, login.getRole());
		return this.insertStatement.executeUpdate();
	}
	/*public int update( Login login )throws Exception
	{
		
		this.updateStatement.setString(1, login.getUsername());
		this.updateStatement.setString(2, login.getPassword());
		this.updateStatement.setString(3, login.getRole());
		this.updateStatement.setInt(4, login.getID());
		return this.updateStatement.executeUpdate();
	}*/
	public String loginValidate(String Username){
		 boolean status;		
			try {
				this.checkStatement.setString(1, Username);
				try( ResultSet rs = checkStatement.executeQuery() ) {
					if(rs.next()) {
						return rs.getString("Email");
					}
				}
			}
			catch(Exception e){
				System.out.println(e.getStackTrace());
			}
			return "";
		 }
		
	
	/*public int delete( Login login )throws Exception
	{
		this.deleteStatement.setInt(1,login.getID());
		return this.deleteStatement.executeUpdate();
	}
	public List<Login> getUsersList()throws Exception
	{
		List<Login> UserList = new ArrayList<Login>();		
		try(ResultSet rs = this.selectStatement.executeQuery();)
		{
			while( rs.next())
			{
				Login login = new Login(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4));
				UserList.add(login);
			}
		}
		return UserList;
	}*/
	@Override
	public void close() throws IOException
	{
		try
		{
			this.insertStatement.close();
			//this.updateStatement.close();
			//this.deleteStatement.close();
			//this.selectStatement.close();
			super.close();
		} 
		catch (SQLException e)
		{
			throw new IOException(e);
		}
	}
}
