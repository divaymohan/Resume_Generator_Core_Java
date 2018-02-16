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

import Resume.ExtraCurricularProgram;
import Resume.ExtraCurricularDetails;
public class ExtraCurricularDao extends UDao
{	
	
	PreparedStatement searchStatement;
	PreparedStatement updateStatement;
	PreparedStatement deleteStatement;
	PreparedStatement selectStatement;
	ResultSet resultset;
	public ExtraCurricularDao()throws Exception
	{			
		this.searchStatement = this.connection.prepareStatement("select * from extra_curricular where StudentID = ?");
		this.updateStatement = this.connection.prepareStatement("update extra_curricular set Achievement=?,Description=?, Date=? where StudentID=?");
		this.deleteStatement = this.connection.prepareStatement("delete from extra_curricular where ID=?");
		this.selectStatement = this.connection.prepareStatement("select * from extra_curricular");
	}
	
	public ResultSet search(ExtraCurricular exc )throws Exception
	{
		this.searchStatement.setInt(1, exc.getStudentId());
		//String sql1 = "SELECT * FROM Students WHERE ID=?";
		//Statement s=connection.prepareStatement(sql1);
		//s.setInt(1,student.);
		
		resultset=searchStatement.executeQuery();
		while(resultset.next()){
			System.out.println( resultset.getInt(1) + " " + resultset.getInt(2) + " " + resultset.getString(3)+ " " + resultset.getString(4)+ " " + resultset.getDate(5));
			
			
		}
		return resultset;
				
				
	}
	public int update( ExtraCurricular extracurricular )throws Exception
	{
		
		//this.updateStatement.setInt(1, extracurricular.getStudentId());
		this.updateStatement.setString(1, extracurricular.getAchievement());
		this.updateStatement.setString(2, extracurricular.getDescription());
		this.updateStatement.setString(3, extracurricular.getDate());
		this.updateStatement.setInt(4, extracurricular.getStudentId());
				
		return this.updateStatement.executeUpdate();
	}
	public int delete( ExtraCurricular extracurricular )throws Exception
	{
		this.deleteStatement.setInt(1,extracurricular.getID());
		return this.deleteStatement.executeUpdate();
	}
	public List<ExtraCurricular> getCurricularList()throws Exception
	{
		List<ExtraCurricular> CurricularList = new ArrayList<ExtraCurricular>();		
		try(ResultSet rs = this.selectStatement.executeQuery();)
		{
			while( rs.next())
			{
				ExtraCurricular address = new ExtraCurricular(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5));
				CurricularList.add(address);
			}
		}
		return CurricularList;
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
