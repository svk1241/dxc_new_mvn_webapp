package com.dxc.studentdemo.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class DBConnection
{
    public static Connection getConnection() throws Exception
    {    
    	String url="jdbc:mysql://localhost:3306/svk";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url,"root","1999");
        
    	}
    public static void closeConnection(Connection con)
    {
    	try
    	{
    		  if(con!=null) con.close();
    		  
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }
    public static void closeStatement(Statement st)
    {
    	try
    	{
    		 if(st!=null) st.close();
    		 
    	}
    	catch(Exception ex)
    	{
    		 ex.printStackTrace();
    	}
    }
    	 public static void closeResultSet(ResultSet rs)
    	    {
    	    	try
    	    	{
    	    		 if(rs!=null) rs.close();
    	    		 
    	    	}
    	    	catch(Exception ex)
    	    	{
    	    		 ex.printStackTrace();
    	    	}
    }
}
