package com.dxc.form.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.dxc.form.bean.WebForm;


public class FormDAO 
{
	public boolean insertFormDetails(WebForm f)
	{
		Connection con=null;
		PreparedStatement pst =null;
		int count=0;
		try
		{
			 con=DBConnection.getConnection();
			 pst=con.prepareStatement("insert into form values(?,?,?,?)");
			 pst.setString(1, f.getName()); pst.setString(2, f.getEmail());
			 pst.setString(3, f.getWebsite()); pst.setString(4, f.getMessage());
			 count =pst.executeUpdate();
		 }
		catch(Exception ex)
		{
			 ex.printStackTrace();
		}
		finally
		{
			DBConnection.closeStatement(pst);
			DBConnection.closeConnection(con);
			
		}
		return count==1;
	}

}
