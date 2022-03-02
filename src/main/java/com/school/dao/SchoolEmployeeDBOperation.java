package com.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


 ;


public class SchoolEmployeeDBOperation {
	
	DBconnection ob=new DBconnection();
	Connection conn=ob.connection();
	public boolean login(long eid,String Password) throws SQLException 
	{
		
		
		PreparedStatement stmt=conn.prepareStatement("select * from schoolemployee where schEmpId=? and schEmpPassword=? ");
		stmt.setLong(1, eid);
		stmt.setString(2, Password);
		
		ResultSet result=stmt.executeQuery();
		if(result.next())
		{
			return true;
		}
		else
		{
			return false;
		}

		
	}
	
	public boolean accountClose(long studId)throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("delete from student where studID=? ");
		stmt.setLong(1, studId);
		int affectedRows=stmt.executeUpdate();
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	 synchronized public boolean openAccount (Student  e) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
		stmt.setLong(1, e.getstudId());
		stmt.setString(2, e.getstudName());
		stmt.setString(3, e.getstudAddress());
		stmt.setInt(4, e.getstudclass());
		stmt.setString(5, e.getstudPassword());
		stmt.setLong(6,e.getphone());
		stmt.setString(7, e.getstudEmail());

		
		int affectedRows=stmt.executeUpdate();
		
		if(affectedRows>0)
		
		   return true;
		
		else
		
		    	return false;
		
		
}
	public ResultSet checkstudinfo(long studId) 
	{
		ResultSet result=null;
		try
		{
		PreparedStatement stmt=conn.prepareStatement("select * from student where studId=? ");
		stmt.setLong(1, studId);
		
		
		 result=stmt.executeQuery();
		}
		catch(Exception e) 
		{
			System.out.println("Wrong studId!!");
		}
	return result;
	}
	public boolean changePassword(long EmpId,String newPassword) throws SQLException
	{
		PreparedStatement stmt=conn.prepareStatement("update schoolemployee set schEmpPassword=? where schEmpId=? ");
		stmt.setString(1,newPassword);
		stmt.setLong(2, EmpId);
		int affectedRows=stmt.executeUpdate();
		if(affectedRows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
		public void logout() throws SQLException
		{
			conn.close();
			
		}
	
}



