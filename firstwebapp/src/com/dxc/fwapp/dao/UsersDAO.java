package com.dxc.fwapp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.dxc.fwapp.bean.Users;
public class UsersDAO
{
   public boolean validateUser(Users u)
   {
	   Connection con = null;
	   PreparedStatement pst = null;
	   ResultSet rs = null;
	   int count = 0;
	   try
	   {
		   con = DBConnection.getConnection();
		   pst = con.prepareStatement("select * from users where username=? and password=?");
		   pst.setNString(1, u.getUsername());   pst.setNString(2, u.getPassword());
		   rs = pst.executeQuery();
		   if(rs.next()) count =1;
	   }
	   catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   DBConnection.closeResultSet(rs);
		   DBConnection.closeStatement(pst);
		   DBConnection.closeConnection(con);
	   }
	   return count == 1;
   }
}