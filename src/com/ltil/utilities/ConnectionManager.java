package com.ltil.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	private static Connection connection;
	
	public static Connection getConnection()
	{
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String uname="hr";
		String pwd="hr";
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			 connection=DriverManager.getConnection(url,uname,pwd);	
		} 
		catch (ClassNotFoundException e) 
		{	
			e.printStackTrace();
		}
		catch(SQLException sq)
		{
			sq.printStackTrace();
		}
		return connection;
	}
	
}
