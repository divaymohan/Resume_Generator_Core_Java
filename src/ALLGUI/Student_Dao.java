package ALLGUI;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Resume.StudentProgram;
import Resume.StudentInfo;
public class Student_Dao extends UDao
{	
	
	PreparedStatement searchStatement;
	PreparedStatement updateStatement;
	PreparedStatement deleteStatement;
	PreparedStatement selectStatement;
	PreparedStatement selectidStatement;
	PreparedStatement searchEmail;
	ResultSet resultset;
	public Student_Dao()throws Exception
	{			
		
		this.searchStatement = this.connection.prepareStatement("select * from students where ID = ?");
		this.updateStatement = this.connection.prepareStatement("update students set First_Name=?,Middle_Name=?, Last_Name=?,Birth_Date=?,Mobile = ?,Hobbies = ?,Company = ?,Placed_Date = ? where ID=?");
		this.deleteStatement = this.connection.prepareStatement("delete from students where ID=?");
		this.selectStatement = this.connection.prepareStatement("select * from students");
		//this.selectidStatement = this.connection.prepareStatement("select ID from student where Email = ?");
		//this.selectidStatement = this.connection.prepareStatement("select Email from student where ID = ?");
	}
	public String getUser(String string) throws Exception{
		 //Util.open();
		// boolean status;
		 //conn = Util.getConnection() ;
		String sql = "SELECT ID FROM Students WHERE Email=?";		
		try( PreparedStatement stmt = connection.prepareStatement(sql) ) {
			stmt.setString(1, string);
			try( ResultSet rs = stmt.executeQuery() ) {
				if(rs.next()) {
				 
					return rs.getString("ID");
				}
			}
		}
		
		return "";
	}
	public String getUserEmail(int id) throws Exception{
		 //Util.open();
		// boolean status;
		 //conn = Util.getConnection() ;
		String sql = "SELECT Email FROM Students WHERE ID=?";		
		try( PreparedStatement stmt = connection.prepareStatement(sql) ) {
			stmt.setInt(1, id);
			try( ResultSet rs = stmt.executeQuery() ) {
				if(rs.next()) {
				 
					return rs.getString("Email");
				}
			}
		}
		
		return "";
	}
	/*public Student validationCheck(String email) throws Exception{
		 
		 Student student=null;
		//Util.open();
		
		 //conn = Util.getConnection() ;
		 
		String sql = "SELECT Email FROM Students WHERE Email=?";		
		
		try( PreparedStatement stmt = connection.prepareStatement(sql) ) {
			
			stmt.setString(1,email);
			
			try( ResultSet rs = stmt.executeQuery() ) 
			{
				if(rs.next()) {
				 Student stud = new Student();
				
				 stud.setEmailId(rs.getString("Email"));
					
					
				} 
			}
			
		}
		catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	}*/
	
	public ResultSet search(Student student )throws Exception
	{
		this.searchStatement.setInt(1, student.getStudentId());
		//String sql1 = "SELECT * FROM Students WHERE ID=?";
		//Statement s=connection.prepareStatement(sql1);
		//s.setInt(1,student.);
		
		resultset=searchStatement.executeQuery();
		while(resultset.next()){
			System.out.println( resultset.getInt(1) + " " + resultset.getString(2) + " " + resultset.getString(3)+ " " + resultset.getString(4)+ " " + resultset.getString(5)+ " " + resultset.getString(6)+ " " + resultset.getString(7)+ " " + resultset.getString(8)+ " " + resultset.getString(9)+ " " + resultset.getString(10));
			
		}
		return resultset;
				
				
	}
	@SuppressWarnings("deprecation")
	public int update( Student student )throws Exception
	{
		//Date d = new Date();
		
		/*Calendar c1 = Calendar.getInstance();
		int day = c1.get(Calendar.DATE);
		int month = c1.get(Calendar.MONTH);
		int year = c1.get(Calendar.YEAR);*/
		
		
		this.updateStatement.setString(1, student.getFirstName());
		this.updateStatement.setString(2, student.getMiddleName());
		this.updateStatement.setString(3, student.getLastName());
		this.updateStatement.setString(4, student.getBirthDate());
		this.updateStatement.setInt(5, student.getMobileNo());
		this.updateStatement.setString(6, student.getHobby());
		this.updateStatement.setString(7, student.getCompany());
		this.updateStatement.setString(8, student.getPlaceDate());
		this.updateStatement.setInt(9, student.getStudentId());
		
		return this.updateStatement.executeUpdate();
	}
	public int delete( Student student )throws Exception
	{
		this.deleteStatement.setInt(1,student.getStudentId());
		return this.deleteStatement.executeUpdate();
	}
	public List<Student> getStudentList()throws Exception
	{
		List<Student> StudentList = new ArrayList<Student>();		
		try(ResultSet rs = this.selectStatement.executeQuery();)
		{
			while( rs.next())
			{
				//Student student = new Student(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getDate(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9),rs.getDate(10));
				
				//StudentList.add(student);
			}
		}
		return StudentList;
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
