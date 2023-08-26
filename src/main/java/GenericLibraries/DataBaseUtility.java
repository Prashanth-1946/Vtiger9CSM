package GenericLibraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains reusable methods to perform operations on database
 * @author Welcome
 *
 */

public class DataBaseUtility 
{
	private Connection connection;
	private Statement statem;
	
	
	/**
	 * This method is used to connect to database
	 * @param url
	 * @param user
	 * @param pwd
	 */
	public void databaseInitialization(String url, String user, String pwd)
	{
		Driver dbDriver=null;
		try{
			dbDriver= new Driver();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		try {
		DriverManager.registerDriver(dbDriver);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			connection=DriverManager.getConnection(url,user,pwd);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			statem=connection.createStatement();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to read data form database
	 * @param query
	 * @param columnName
	 * @return
	 * @throws SQLException
	 */
	
	public List<Object> readFromDataBase(String query,String columnName) throws SQLException  
	{
	  ResultSet result=statem.executeQuery(query);
	
	
	List<Object> list=new ArrayList<Object>();
	while(result.next())
	{
		list.add(result.getString(columnName));
		
	}
	return list;
	}
	/**
	 * This method is used modify the database
	 * @param query
	 * @return
	 */
	public int modifyDatabase(String query)
	{
		int result=0;
		try {
			result=statem.executeUpdate(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * This method is used to close the database connection
	 * @throws SQLException
	 */
	public void closeDataBase() throws SQLException
	{
		connection.close();
	}

}
