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

import Resume.SubjectProgram;
import Resume.Subject;
public class SubjectDao extends SubDao
{	
	PreparedStatement insertStatement;
	PreparedStatement searchStatement;
	PreparedStatement updateStatement;
	PreparedStatement deleteStatement;
	PreparedStatement selectStatement;
	ResultSet resultset;
	public SubjectDao()throws Exception
	{
		this.insertStatement = this.connection.prepareStatement("insert into subjects(Name,Semester,Stream,MaxMarks,Type) values(?,?,?,?,?)");
		this.searchStatement = this.connection.prepareStatement("select * from subjects where ID = ?");
		this.updateStatement = this.connection.prepareStatement("update subjects set Name=?,Semester=?, Stream=?,MaxMarks=?,Type = ? where ID=?");
		this.deleteStatement = this.connection.prepareStatement("delete from subjects where ID=?");
		this.selectStatement = this.connection.prepareStatement("select * from subjects");
	}
	
	public int insert(Sub subject )throws Exception
	{
		//this.insertStatement.setInt(1, subject.getID());
		this.insertStatement.setString(1, subject.getName());
		this.insertStatement.setString(2, subject.getSemester());
		this.insertStatement.setString(3, subject.getStream());
		this.insertStatement.setInt(4, subject.getMaxMarks());
		this.insertStatement.setString(5, subject.getType());
		return this.insertStatement.executeUpdate();
	}
	public ResultSet search(Sub subject )throws Exception
	{
		this.searchStatement.setInt(1, subject.getID());
		//String sql1 = "SELECT * FROM Students WHERE ID=?";
		//Statement s=connection.prepareStatement(sql1);
		//s.setInt(1,student.);
		
		resultset=searchStatement.executeQuery();
		while(resultset.next()){
			System.out.println( resultset.getInt(1) + " " + resultset.getString(2) + " " + resultset.getString(3)+ " " + resultset.getString(4)+ " " + resultset.getString(5)+ " " + resultset.getString(6)+ " " + resultset.getString(7)+ " " + resultset.getString(8)+ " " + resultset.getString(9)+ " " + resultset.getString(10));
			
		}
		return resultset;
				
				
	}
	public int update( Sub subject )throws Exception
	{
		
		this.updateStatement.setString(1, subject.getName());
		this.updateStatement.setString(2, subject.getSemester());
		this.updateStatement.setString(3, subject.getStream());
		this.updateStatement.setInt(4, subject.getMaxMarks());
		this.updateStatement.setString(5, subject.getType());
		this.updateStatement.setInt(6, subject.getID());
		
		return this.updateStatement.executeUpdate();
	}
	public int delete( Sub subject )throws Exception
	{
		this.deleteStatement.setInt(1,subject.getID());
		return this.deleteStatement.executeUpdate();
	}
	public List<Sub> getSubjectList()throws Exception
	{
		List<Sub> SubjectList = new ArrayList<Sub>();		
		try(ResultSet rs = this.selectStatement.executeQuery();)
		{
			while( rs.next())
			{
				Sub subject = new Sub(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5), rs.getString(6));
				SubjectList.add(subject);
			}
		}
		return SubjectList;
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
