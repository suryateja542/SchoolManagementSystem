package com.school.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	
	public Connection connection()
	{
		Connection conn=null;
		String databaseUrl="jdbc:mysql://localhost:3306/schoolapplication";
		String userName="root";
		String userPassword="Suryateja@542";
				
		try {
			conn=DriverManager.getConnection(databaseUrl,userName,userPassword);
			if(conn!=null)
			{
				System.out.println("connected successfully");
			}
				}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}


}
