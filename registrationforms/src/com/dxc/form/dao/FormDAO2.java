package com.dxc.form.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.dxc.form.bean.WebForm2;

public class FormDAO2 
{
	public boolean insertFormDetails(WebForm2 f)
	{
		Connection con=null;
		PreparedStatement pst =null;
		int count=0;
		try
		{
			 con=DBConnection.getConnection();
			 pst=con.prepareStatement("insert into form values(?,?,?,?,?,?,?,?,?,?)");
			 pst.setLong(1, f.getUserid()); pst.setString(2, f.getPassword());
			 pst.setString(3, f.getName()); pst.setString(4, f.getAddress());
			 pst.setString(5, f.getCountry()); pst.setLong(6, f.getZipcode());
			 pst.setString(7, f.getEmail()); pst.setString(8, f.getSex());
			 pst.setString(9, f.getLanguage()); pst.setString(10, f.getAbout());
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
