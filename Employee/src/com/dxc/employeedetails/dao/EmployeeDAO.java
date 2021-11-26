package com.dxc.employeedetails.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.dxc.employeedetails.bean.Employee;


public class EmployeeDAO 
{
	public boolean insertEmployeeDetails(Employee e)
	{
		Connection con=null;
		PreparedStatement pst =null;
		int count=0;
		try
		{
			 con=DBConnection.getConnection();
			 pst=con.prepareStatement("insert into employee values(?,?)");
			 pst.setInt(1, e.getId()); pst.setString(2, e.getName());
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
	public ArrayList<Employee> getAllEmployeeDetails()
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Employee> elist = new ArrayList<>();
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("select * from employee");
			rs = pst.executeQuery();
			while(rs.next())
				elist.add(new Employee(rs.getInt(1),rs.getString(2)));
			
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
		return elist;
	}

}
