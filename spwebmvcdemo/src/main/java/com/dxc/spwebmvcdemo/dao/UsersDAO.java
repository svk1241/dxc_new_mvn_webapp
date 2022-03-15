package com.dxc.spwebmvcdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.dxc.spwebmvcdemo.bean.Users;
@Repository

public class UsersDAO 
{
	public boolean validateUser(Users u)
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String url ="jdbc:mysql://localhost:3306/svk";
		int count =0;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,"root","1999");
			pst = con.prepareStatement("select count(*) from users where username=? and password=?");
			pst.setString(1, u.getUsername());   pst.setString(2,u.getPassword());
			rs=pst.executeQuery();
			if(rs.next()) count = rs.getInt(1);
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return count == 1;
	}

}
