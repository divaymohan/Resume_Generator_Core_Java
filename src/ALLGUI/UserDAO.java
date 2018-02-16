package ALLGUI;
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
		super();
		this.insertStatement = this.connection.prepareStatement("insert into users(Email,Password,Role) values(?,?,?)");
		//this.updateStatement = this.connection.prepareStatement("update users set Email=?,Password=?, Role=? where ID=?");
		//this.deleteStatement = this.connection.prepareStatement("delete from users where ID=?");
		//this.selectStatement = this.connection.prepareStatement("select * from users");
		this.checkStatement = this.connection.prepareStatement("SELECT Email,Password,ID FROM users WHERE Email=? AND Password=?");
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
	public boolean loginValidateEmail(String Username,String password){		
			try {
				this.checkStatement.setString(1, Username);
				this.checkStatement.setString(2, password);
				
				try( ResultSet rs = checkStatement.executeQuery() ) {
					
					if(rs.next()) {
						return true;
						
					}
				}
				
			}
			catch(Exception e){
				System.out.println(e.getStackTrace());
			}
			return false;
	}
	public boolean getUserRole(String Email) throws Exception{
		 //Util.open();
		// boolean status;
		 //conn = Util.getConnection() ;
		String sql = "SELECT Role FROM users WHERE Email=?";		
		try( PreparedStatement stmt = connection.prepareStatement(sql) ) {
			stmt.setString(1, Email);
			try( ResultSet rs = stmt.executeQuery() ) {
				if(rs.next() && rs.getString("Role").equalsIgnoreCase("administator")) {
				 
					return true;
				}
			}
		}
		
		return false;
	}
			
//			public String loginValidatePassword(String Username){
//				 boolean status;		
//					try {
//						this.checkStatement.setString(1, Username);
//						try( ResultSet rs = checkStatement.executeQuery() ) {
//							if(rs.next()) {
//								return rs.getString(2);
//								
//							}
//						}
//					}
//
//			catch(Exception e){
//				System.out.println(e.getStackTrace());
//			}
//			return "aa";
//		 }
		
	
	/*public int*** delete( Login login )throws Exception
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
