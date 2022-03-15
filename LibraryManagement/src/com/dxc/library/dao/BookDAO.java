package com.dxc.library.dao;
import com.dxc.library.dto.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.DriverManager;

public class BookDAO 
{
	public boolean insertBookDetails(Book b)
	{
		Connection con=null;
		PreparedStatement pst =null;
		int count=0;
		try
		{
			 con=DBConnection.getConnection();
			 pst=con.prepareStatement("insert into book values(?,?,?,?,?)");
			 pst.setInt(1, b.getBookId()); pst.setNString(2, b.getBookTitle());
			 pst.setNString(3, b.getAuthor()); pst.setNString(4, b.getPublisher());
			 pst.setDouble(5,b.getPrice());
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
	public boolean deleteBook(int bookId)
	{
		Connection con= null;
		PreparedStatement pst=null;
		int count=0;
		try
		{
			con=DBConnection.getConnection();
			pst=con.prepareStatement("delete from book where bookid=?");
			pst.setInt(1, bookId);
			count=pst.executeUpdate();
			
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


	public boolean modifyBook(Book b)
	{
		Connection con = null;
		PreparedStatement pst = null;
		int count = 0;
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("update book set publisher=?,price=? where bookid=?");
			pst.setString(1,b.getPublisher());
			pst.setDouble(2,b.getPrice());
			pst.setInt(3,b.getBookId());
			
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

	public Book getBookDetails(int bookId)
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Book b = null;
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("select * from book where bookid=?");
			pst.setInt(1, bookId);
			rs = pst.executeQuery();
			if(rs.next())
				b= new Book(bookId,rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
			
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
		return b;
	}
	public ArrayList<Book> getAllookDetails()
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Book> blist = new ArrayList<>();
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("select * from book");
			rs = pst.executeQuery();
			while(rs.next())
				blist.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5)));
			
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
		return blist;
	}
	public Book getBookDetailsByTitle(String title)
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Book b = null;
		try
		{
			con = DBConnection.getConnection();
			pst = con.prepareStatement("select * from book  where booktitle=?");
			pst.setString(1, title);
			rs = pst.executeQuery();
			if(rs.next())
				b= new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
			
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
		return b;
	}

}
