package com.dxc.library.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dxc.library.dto.BookStatus;
public class BookStatusDAO
{
	public boolean insertBookStatus(BookStatus bs)
	{
		Connection con =null;
		PreparedStatement pst =null;
		int count =0;
		try
		{
			con=DBConnection.getConnection();
			pst=con.prepareStatement("insert into bookstatus values(?,?,?)");
			pst.setInt(1, bs.getBookId()); pst.setInt(2, bs.getTotalCopies()); pst.setInt(3, bs.getAvailableCopies());
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
	public boolean modifyBookStatus(char status,int bookId)
	{
		Connection con =null;
		PreparedStatement pst =null;
		String qry="update bookstatus set  avaialblecopies=avaialblecopies-1 where bookid=?";
		if(status=='r') qry="update bookstatus set  avaialblecopies=avaialblecopies+1 where bookid=?";
		int count =0;
		try
		{
			con=DBConnection.getConnection();
			pst=con.prepareStatement(qry);
			pst.setInt(1, bookId);
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
	public int getAvailableCopies(int bookId)
	{
		Connection con= null;
		PreparedStatement pst =null;
		ResultSet rs =null;
		int copies =0;
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("select avaialblecopies from bookstatus where bookid=?");
			pst.setInt(1,bookId);
			rs=pst.executeQuery();
			if(rs.next()) copies =rs.getInt(1);
			
			
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
		return copies;
		
	}
	}
	


