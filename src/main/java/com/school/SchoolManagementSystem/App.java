package com.school.SchoolManagementSystem;

import java.sql.ResultSet;
import java.util.Scanner;

import com.school.dao.SchoolEmployeeDBOperation;
import com.school.dao.studentDBOperations;
import com.school.entities.Student;
import com.school.entities.SchoolEmployee;



public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("==========================================================================================================");
    	System.out.println("                                             Welcome to XYZ school                                        ");
    	System.out.println("==========================================================================================================");
    	
    	boolean status=true;
    	do
       try
       {
    	Scanner scan=new Scanner(System.in);
    	System.out.println("\t Press 1 -> School Employee ");
    	System.out.println("\t Press 2 -> Student ");
    	int userType=scan.nextInt();
    	
    	SchoolEmployeeDBOperation bo=new SchoolEmployeeDBOperation();
    	
    	if(userType==1)
    	{
    		System.out.println("\t Enter Employee Id:");
    		long eId=scan.nextLong();
    		System.out.println("\t Enter Password:");
    		String Password=scan.next();
    		
    		 System.out.println(Password);
    		 
    		 
    		boolean validUser=bo.login(eId, Password);
    		
    		System.out.println(validUser);
    		
    		if(validUser)
    		{
    	       	System.out.println("==========================================================================================================");
    			System.out.println("Login Successfull!!");
    	       	System.out.println("==========================================================================================================");
    	       	System.out.println("1.Open Account\r\n"
    	       			+ "2.Delete Account\r\n"
    	       			+ "3.Check StudentInfo\r\n"
    	       			+ "4.Password Change\r\n"
    	       			+ "5.Logout");
    	       	int operation=scan.nextInt();
                if(operation==1)
                {
                	System.out.println("Enter student Id for the student:");
                	long studId=scan.nextLong();
                	System.out.println("Enter student name:");
                	String studName=scan.next();
                	System.out.println("Enter student address:");
                	String studAddress=scan.next();
                	System.out.println("Enter student class:");
                	int studclass=scan.nextInt();
                	System.out.println("Enter student password:");
                    String studPassword=scan.next();
                    System.out.println("Enter phone number:");
                    long phone=scan.nextLong();
    	       		System.out.println("Enter email address: :");
    	       		String studEmail=scan.next();
    	       		Student u=new Student(studId, studName, studAddress,studclass,studPassword , phone,studEmail);
    	       		if(bo.openAccount(u))
    	       		{
    	       			System.out.println("==========================================================================================================");
    	       			System.out.println(" Student Account created!!");
    	       			System.out.println("==========================================================================================================");
    	       		}
    	       		else
    	       		{
    	       			System.out.println("Problem in account creation!! ");
    	       		}

                	
                }
                else if(operation==2)
                {
                	System.out.println("Enter student id for closing  student account:");
                	long studId=scan.nextLong();
                	if(bo.accountClose(studId))
                	{
                		System.out.println(" Student Account closed successfully!! ");
	
                	}
                	else
    	       		{
    	       			System.out.println("Problem in account closing!! ");
    	       		}

                }
                else if(operation==3)
                {
                	System.out.println("==========================================================================================================");
        			System.out.println("Student Information ");
        	       	System.out.println("==========================================================================================================");
                    System.out.println("Enter student Id for the Student:");
                    long studId=scan.nextLong();
                    ResultSet result=bo.checkstudinfo(studId);
                    
                    if(result!=null)
                    {
                    	while(result.next())
                    	{
                    	System.out.println("StudentName:"+result.getString(2));
                    	System.out.println(" Student Address:"+result.getString(3));
                    	System.out.println("Phone number:"+result.getLong(6));
                    	System.out.println("Email:"+result.getString(7));
                    	System.out.println("Class:"+result.getInt(4));
                    }
                }
                else
                {
                	System.out.println("Student Id does not exist!! ");

                }
    		}
    		
    		else if(operation==4)
	       	{
	       		System.out.println("Enter your school Employee Id:");
	       		long eid=scan.nextLong();
	       		System.out.println("Set new Password:");
	       		String newPassword=scan.next();
	       		if(bo.changePassword(eid, newPassword))
	       		{
	       			System.out.println("Password Changed!!");
	       		}
	       		else
	       		{
	       			System.out.println("Error occurred!!");
	       		}
	       	}
            else if(operation==5)
	       	{
	       		bo.logout();
	       		System.out.println("==========================================================================================================");
    			System.out.println("Logged Out!! ");
    	       	System.out.println("==========================================================================================================");

	       	}

    		}

    	else
		{
	       	System.out.println("==========================================================================================================");
			System.out.println("Incorrect StudentId/Password!! ");
	       	System.out.println("==========================================================================================================");

		}
    	}
    		else if(userType==2)
        	{
        		studentDBOperations ob=new studentDBOperations();
        		System.out.println("\t Enter Student Id:");
        		long uId=scan.nextLong();
        		System.out.println("\t Enter password:");
        		String password=scan.next();
        		if(ob.login(uId, password))
        		{
        			System.out.println("======================================================================================================================");
        			System.out.println("\r\n"       +"1.Change Password\r\n"
        			                                                      +"2.Logout");
        		
        			int operation =scan.nextInt();
        		
    	        if(operation==1)
    	       	{
    	    		System.out.println("Enter new password:");
    	    		String newPassword=scan.next();
    	       		if(ob.changePassword(uId, newPassword))
    	       		{
    	       			System.out.println("==========================================================================================================");
    	    			System.out.println("Password changed successfully!!");
    	    	       	System.out.println("==========================================================================================================");

    	       		}
    	       		else
    	       		{
    	       			System.out.println("==========================================================================================================");
    	    			System.out.println("Problem in password change!!");
    	    	       	System.out.println("==========================================================================================================");

    	       		}
    	       	}
               
    	       	else if(operation==2)
    	       	{
    	       		ob.logout();
    	       		status=false;
    	       		System.out.println("==========================================================================================================");
        			System.out.println("Logged Out!!");
        	       	System.out.println("==========================================================================================================");

    	       	}
    	    	else 
    	       	{
    	    		System.out.println("==========================================================================================================");
        			System.out.println("Wrong Input!!");
               
    	       	}
    			
    		}
    		else
    		{
    			System.out.println("==================================================================================================================");
    			System.out.println("User Id or password incorrect!!");
    			System.out.println("==================================================================================================================");
    				
    		}
    		
    	}

    	else
    	{
    		System.out.println("\t Please enter a correct input!!");
    	}
       }
       catch(Exception e)
       {
    	   System.out.println(e.getMessage());
    	   System.out.println("\t Wrong Input!!");
    	   System.out.println("\t Provide Number input!!");
       	   System.out.println("==========================================================================================================");
       }
       
    while(status);
        	
       }
}
    