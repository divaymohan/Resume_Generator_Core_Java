package ALLGUI;
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

import Resume.ProjectProgram;
import Resume.ProjectDetails;
public class ProjectDao extends UDao
{	
	
	PreparedStatement searchStatement;
	PreparedStatement updateStatement;
	PreparedStatement deleteStatement;
	PreparedStatement selectStatement;
	ResultSet resultset;
	public ProjectDao()throws Exception
	{			
		this.searchStatement = this.connection.prepareStatement("select * from projects where StudentID = ?");
		this.updateStatement = this.connection.prepareStatement("update projects set Team_Size=?,Duration=?, Technology=?,Title=?,Description=?,ProjectType=? where ID=?");
		this.deleteStatement = this.connection.prepareStatement("delete from projects where ID=?");
		this.selectStatement = this.connection.prepareStatement("select * from projects");
	}
	public int getUser(int studentId) throws Exception{
		 //Util.open();
		// boolean status;
		 //conn = Util.getConnection() ;
		String sql = "SELECT ID FROM projects WHERE StudentID=?";		
		try( PreparedStatement stmt = connection.prepareStatement(sql) ) {
			stmt.setInt(1, studentId);
			try( ResultSet rs = stmt.executeQuery() ) {
				if(rs.next()) {
				 
					return Integer.parseInt(rs.getString("ID"));
				}
			}
		}
		
		return 0;
	}
	
	public ResultSet search(Project project )throws Exception
	{
		this.searchStatement.setInt(1, project.getStudentId());
		//String sql1 = "SELECT * FROM Students WHERE ID=?";
		//Statement s=connection.prepareStatement(sql1);
		//s.setInt(1,student.);
		
		resultset=searchStatement.executeQuery();
		while(resultset.next()){
			System.out.println( resultset.getInt(1) + " " + resultset.getInt(2) + " " + resultset.getString(3)+ " " + resultset.getString(4)+ " " + resultset.getDate(5));
			
			
		}
		return resultset;
				
				
	}
	public int update( Project project )throws Exception
	{
		
		//this.updateStatement.setInt(1, extracurricular.getStudentId());
		this.updateStatement.setInt(1, project.getTeamSize());
		this.updateStatement.setString(2, project.getDuration());
		this.updateStatement.setString(3, project.getTechnology());
		this.updateStatement.setString(4, project.getTitle());
		this.updateStatement.setString(5, project.getDescription());
		this.updateStatement.setString(6, project.getProjectType());
		this.updateStatement.setInt(7, project.getID());
		return this.updateStatement.executeUpdate();
	}
	public int delete( Project project )throws Exception
	{
		this.deleteStatement.setInt(1,project.getID());
		return this.deleteStatement.executeUpdate();
	}
	public List<Project> getProjectList()throws Exception
	{
		List<Project> ProjectList = new ArrayList<Project>();		
		try(ResultSet rs = this.selectStatement.executeQuery();)
		{
			while( rs.next())
			{
				Project address = new Project(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				ProjectList.add(address);
			}
		}
		return ProjectList;
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
