package Resume;
import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import Resume.ExtraCurricularProgram;

public class AcDao implements Closeable
{
	protected Connection connection;
	public AcDao()throws Exception
	{
		this.open();
	}
	private void open()throws Exception
	{
		if( this.connection == null )
		{
			Properties properties = new Properties();		
			properties.load(AcademicsProgram.class.getClassLoader().getResourceAsStream("config.properties"));		
			Class.forName(properties.getProperty("DRIVER"));			
			connection = DriverManager.getConnection(properties.getProperty("URL"), properties.getProperty("USER"), properties.getProperty("PASSWORD"));
		}
	}
	@Override
	public void close() throws IOException
	{
		try
		{
			this.connection.close();
		} 
		catch (SQLException e)
		{		
			throw new IOException(e);
		}
	}
}
