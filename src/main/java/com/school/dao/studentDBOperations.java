package com.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class studentDBOperations {
	

		 DBconnection ob=new DBconnection();
		 Connection conn=ob.connection();
		
		 	public boolean login(long studId,String password) throws SQLException
			{
					
				PreparedStatement stmt=conn.prepareStatement("select * from student where studId=? and studPassword=? ");
				stmt.setLong(1, studId);
				stmt.setString(2,password);
				
				ResultSet result=stmt.executeQuery();
				if(result.next()) //true or false
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
		 	
		 	public boolean changePassword(long studId,String newPassword) throws SQLException
			{
				PreparedStatement stmt=conn.prepareStatement("update student set studPassword=? where studId=? ");
				stmt.setString(1,newPassword);
				stmt.setLong(2, studId);
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
		 	

}
