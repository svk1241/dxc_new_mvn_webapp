package dxc.web.lib2.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dxc.web.lib2.bean.Transaction;
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
	public boolean returnBookTransaction(int memberId,int bookId) 
	{
		Connection con =null;
		PreparedStatement pst =null;
		int count =0;
		try
		{
			con= DBConnection.getConnection();
			pst= con.prepareStatement("update transaction set  bookreturndate=sysdate(),status ='r' where memberid =? and bookid=?");
			pst.setInt(1, memberId); pst.setInt(2, bookId);
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
	public ArrayList<Object[]> getTransactionDetailsByMemberId(int memberId)
	{
		Connection con =null;
		PreparedStatement pst =null;
		ResultSet rs = null;
		ArrayList<Object[]> tlist = new ArrayList<>();
		try
		{
			con= DBConnection.getConnection();
			pst= con.prepareStatement("select b.bookId,booktitle,bookissuedate,status from book b ,transaction t where t.bookid=b.bookid and t.status='i' and memberid=?");;
			pst.setInt(1, memberId);
			rs=pst.executeQuery();
			while(rs.next())
			{
			Object[] 	t =  new Object[4];
			t[0]=rs.getInt(1);t[1]=rs.getString(2);
			t[2]=rs.getString(3);
			t[3]=rs.getString(4);
			tlist.add(t);
			}
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
		return tlist;
	}

}
