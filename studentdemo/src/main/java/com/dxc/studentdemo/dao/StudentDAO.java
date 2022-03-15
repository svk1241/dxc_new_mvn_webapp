package com.dxc.studentdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.dxc.studentdemo.bean.Student;
import com.dxc.studentdemo.dao.DBConnection;
import com.dxc.studentdemo.bean.Student;
@Repository
public class StudentDAO 
{
	 public boolean insertStudentDetails(Student s)
	    {
	    	Connection con = null;
	    	PreparedStatement pst = null;
	    	int count =0;
	    	try
	    	{
	    		con = DBConnection.getConnection();
	    		pst = con.prepareStatement("insert into student values(?,?,?,?,?)");
	    		pst.setInt(1, s.getSrNo()); pst.setString(2, s.getName());
	    	    pst.setInt(3, s.getAge()); pst.setLong(4,s.getPhone());
	    	    pst.setString(5, s.getAddress()); 
	    	    count = pst.executeUpdate();    
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
	    	return count == 1;
	    }
	 public Student getStudentDetails(int srNo)
	    {
	    	Connection con = null;
	    	PreparedStatement pst = null;
	    	ResultSet rs = null;
	    	 Student s = null;
	    	try
	    	{
	    		con = DBConnection.getConnection();
	    		pst = con.prepareStatement("select * from book where bookid=?");
	    		pst.setInt(1, srNo);
	    		rs = pst.executeQuery();
	    		if(rs.next())
	    			s= new Student(srNo,rs.getString(2),rs.getInt(3),rs.getString(4),rs.getLong(5));
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
	    	return s;
	    }

}
