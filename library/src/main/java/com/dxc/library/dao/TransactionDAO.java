package com.dxc.library.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dxc.library.dto.Transaction;
public class TransactionDAO
{
	public boolean issueBookTransaction(Transaction t)
	{
		Connection con =null;
		PreparedStatement pst =null;
		int count =0;
		try
		{
			con =DBConnection.getConnection();
			pst =con.prepareStatement("insert into transaction(memberid,bookid,bookissuedate,status) values(?,?,?,?)");
			pst.setInt(1, t.getMemberId()); pst.setInt(2,t.getBookId());
			pst.setDate(3,Date.valueOf( t.getBookIssueDate())); 
			pst.setString(4, String.valueOf(t.getStatus()));
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
		return  count == 1;
	}
	public boolean returnBookTransaction(int memberId) 
	{
		Connection con =null;
		PreparedStatement pst =null;
		int count =0;
		try
		{
			con= DBConnection.getConnection();
			pst= con.prepareStatement("update transaction set  bookreturndate=sysdate(),status ='r' where memberid =?");
			pst.setInt(1, memberId);
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
		return  count == 1;
		
	}

}
