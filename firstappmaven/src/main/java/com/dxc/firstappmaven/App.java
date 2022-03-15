package com.dxc.firstappmaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	String url = "jdbc:mysql://localhost:3306/svk";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(url,"root","1999");
        PreparedStatement pst = con.prepareStatement("select * from book");
        ResultSet rs =pst.executeQuery();
        while(rs.next())
        	System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
    }
}
