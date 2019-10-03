package com.ltil.dao;

import com.ltil.model.User;
import com.ltil.utilities.ConnectionManager;
import java.sql.*;

public class UserDaoImp implements UserDao{
	
	private Connection connection=ConnectionManager.getConnection();
	private String query1="select * from shopusers where userid=? and password=?";
	private String query2="insert into shopusers(name, userid, password) values(?,?,?) ";
	private PreparedStatement ps1=null;
	private PreparedStatement ps2=null;
	private ResultSet rs=null;
	
	
	@Override
	public boolean validateUser(User user) {
		
		//PreparedStatement ps=connection.prepareStatement(query);
		 
		//ResultSet rs=null;
		
		try
		{
			System.out.println("Hello");
			System.out.println(connection);
			ps1=connection.prepareStatement(query1);
			ps1.setString(1, user.getUserid());
			ps1.setString(2, user.getPassword());
			
			ResultSet  rs=ps1.executeQuery();
			while(rs.next())
			{
				return true;
			}
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean addUser(User user) {
		
		
		
		//PreparedStatement ps=connection.prepareStatement(query);
		//ResultSet rs=null;
		
		try 
		{
			ps2=connection.prepareStatement(query2);
			//PreparedStatement ps=connection.prepareStatement(query2);
			ps2.setString(1, user.getUsername());
			ps2.setString(2, user.getUserid());
			ps2.setString(3, user.getPassword());
			
			int i=ps2.executeUpdate();
			
			if(i==1)
			{
				return true;
			}
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return false;
	}

}
