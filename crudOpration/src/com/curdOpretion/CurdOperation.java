package com.curdOpretion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CurdOperation {

	public static void main(String[] args)throws ClassNotFoundException,SQLException {
		
    try
    {
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/room","root","123456");
    	Statement st=con.createStatement();
    	
    	ResultSet rs;
    	PreparedStatement ps = null;
    	
    	String qury="";
    	int id,choice,age;
    	String name,city;
    	Scanner sc1=new Scanner(System.in);
    	Scanner sc2=new Scanner(System.in);
    	while(true)
    	{
    		System.out.println("My Sql Java Curd Opretion ");
    		System.out.println("1. Insert");
    		System.out.println("2. Update");
    		System.out.println("3. Delete");
    		System.out.println("4. Select");
    		System.out.println("5.Exit");
    		System.out.println("Enter your choice: ");
    		choice=sc1.nextInt();
    		System.out.println("=======================");
    		switch(choice) {
    		case 1:
    			System.out.println("1.Insert New Data");   			
    			System.out.println("Enter Name : ");
    			name=sc2.nextLine();
    			System.out.println("Enter Age : ");
    			age=sc1.nextInt();
    			System.out.println("Enter City : ");
    			city=sc2.nextLine();
    			
    			qury="insert into user1(NAME,AGE,CITY)values(?,?,?)";
    			ps=con.prepareStatement(qury);
    			ps.setString(1,name);
    			ps.setInt(2, age);
    			ps.setString(3,city);
    			
    			ps.executeUpdate();
    			System.out.println("Data Insert Success");
    			
    			break;
    		  case 2:
    			  System.out.println("2.Updating a Data");
    			  
    			  System.out.println("Enter ID :");
    			  id=sc1.nextInt();
    			  System.out.println("Enter Name : ");
    			  name=sc2.nextLine();
    			  System.out.println("Enter Age : ");
    			  age=sc1.nextInt();
    			  System.out.println("Enter City : ");
    			  city=sc2.nextLine();
    			  qury="update user1 set NAME=?,AGE=?,CITY=? where ID=?";
    			  ps=con.prepareStatement(qury);
    			  
    			  ps.setString(1,name);
    			  ps.setInt(2, age);
    			  ps.setString(3, city);
    			  ps.setInt(4, id);
    			  
    			  ps.executeUpdate();
    			  System.out.println("Data Update Success5");
    			  
    			  break;
    			  
    		  case 3:
    			  System.out.println("3.Deleting a Data");
    			  System.out.println("Enter ID :");
    			  id=sc1.nextInt();
    			  
    			  qury="delete from user1 where ID=?";
    			ps= con.prepareStatement(qury);
    			  ps.setInt(1, id);
    			  ps.executeUpdate();
    			  System.out.println("Data Deleted Success");
    			  
    			  break;
    		  case 4:
    			  System.out.println("4.Print all Records");
    			  qury="Select ID,NAME,AGE,CITY from user1";
    			  rs=st.executeQuery(qury);
    			  while(rs.next())
    			  {
    				  id=rs.getInt("ID");
    				  name=rs.getString("NAME");
    				  age=rs.getInt("AGE");
    				  city=rs.getString("city");
    				  
    				  System.out.println(id+" ");
    				  System.out.println(name+" ");
    				  System.out.println(age+" ");
    				  System.out.println(city+" ");
    				  
    			  }
    			  break;
    		  case 5:
    			  System.out.println("Thank you");
    			  System.exit(0);
    			  break;
    			  default:
    				  System.out.println("Invalid selection");
    				  break;
    		}
    		System.out.println("==========================="); }  			  		
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}
}

