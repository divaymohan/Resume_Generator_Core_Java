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

import Resume.AcademicsProgram;
import Resume.AcademicsDetails;
public class AcademicsDao extends AcDao
{	
	
	PreparedStatement searchStatement;
	PreparedStatement updateStatement;
	PreparedStatement deleteStatement;
	PreparedStatement selectStatement;
	ResultSet resultset;
	public AcademicsDao()throws Exception
	{			
		this.searchStatement = this.connection.prepareStatement("select * from academics where StudentID = ?");
		this.updateStatement = this.connection.prepareStatement("update academics set Institute=?, University=?,YearOfPassing=?,Percentage=? where ID=?");
		this.deleteStatement = this.connection.prepareStatement("delete from academics where ID=?");
		this.selectStatement = this.connection.prepareStatement("select * from academics");
	}
	
	public ResultSet search(Academics ac )throws Exception
	{
		this.searchStatement.setInt(1, ac.getStudentId());
		//String sql1 = "SELECT * FROM Students WHERE ID=?";
		//Statement s=connection.prepareStatement(sql1);
		//s.setInt(1,student.);
		
		resultset=searchStatement.executeQuery();
		while(resultset.next()){
			System.out.println( resultset.getInt(1) + " " + resultset.getInt(2) + " " + resultset.getString(3)+ " " + resultset.getString(4)+ " " + resultset.getDate(5));
			
			
		}
		return resultset;
				
				
	}
	public int update( Academics ace )throws Exception
	{
		
		//this.updateStatement.setInt(1, extracurricular.getStudentId());
		//this.updateStatement.setString(1, ace.getExam());
		this.updateStatement.setString(1, ace.getInstitute());
		this.updateStatement.setString(2, ace.getUniversity());
		this.updateStatement.setString(3, ace.getYearOfPassing());
		this.updateStatement.setString(4, ace.getScore());
		this.updateStatement.setInt(5, ace.getID());
		
		
				
		return this.updateStatement.executeUpdate();
	}
	public int delete( Academics ace )throws Exception
	{
		this.deleteStatement.setInt(1,ace.getID());
		return this.deleteStatement.executeUpdate();
	}
	public List<Academics> getAcademicList()throws Exception
	{
		List<Academics> AcademicList = new ArrayList<Academics>();		
		try(ResultSet rs = this.selectStatement.executeQuery();)
		{
			while( rs.next())
			{
				Academics academics = new Academics(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7));
				AcademicList.add(academics);
			}
		}
		return AcademicList;
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
