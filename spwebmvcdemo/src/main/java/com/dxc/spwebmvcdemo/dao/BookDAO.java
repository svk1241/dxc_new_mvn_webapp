package com.dxc.spwebmvcdemo.dao;
import com.dxc.spwebmvcdemo.bean.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
@Repository
public class BookDAO 
{
    public boolean insertBookDetails(Book b)
    {
    	Connection con = null;
    	PreparedStatement pst = null;
    	int count =0;
    	try
    	{
    		con = DBConnection.getConnection();
    		pst = con.prepareStatement("insert into book values(?,?,?,?,?,?,?,?)");
    		pst.setInt(1, b.getBookId()); pst.setString(2, b.getBookTitle());
    	    pst.setString(3, b.getAuthor()); pst.setString(4,  b.getPublisher());
    	    pst.setDouble(5, b.getPrice()); pst.setString(6, b.getSubject());
    	    pst.setInt(7, b.getTotalCopies());  pst.setInt(8, b.getTotalCopies());
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
    public boolean deleteBook(int bookId)
    {
    	Connection con = null;
    	PreparedStatement pst = null;
    	int count =0;
    	try
    	{
    		con = DBConnection.getConnection();
    		pst = con.prepareStatement("delete from book where bookid=?");
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
    public boolean modifyBook(Book b)
    {
    	Connection con = null;
    	PreparedStatement pst = null;
    	int count =0;
    	try
    	{
    		con = DBConnection.getConnection();
    		pst = con.prepareStatement("update book set publisher=?,price=?,totalcopies=? where bookid=?");
    		pst.setString(1, b.getPublisher());  pst.setDouble(2, b.getPrice());
    		pst.setInt(3, b.getTotalCopies());   pst.setInt(4, b.getBookId());
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
    			b= new Book(bookId,rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getInt(7),rs.getInt(8));
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
    public ArrayList<Book> getAllBooksDetails()
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
    			 blist.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getInt(7),rs.getInt(8)));
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
   
    
    public ArrayList<Book> getBooksBySubject(String subject)
    {
    	Connection con = null;
    	PreparedStatement pst = null;
    	ResultSet rs = null;
    	ArrayList<Book> blist = new ArrayList<>();
    	try
    	{
    		con = DBConnection.getConnection();
    		pst = con.prepareStatement("select * from book where subject like ?");
    		pst.setString(1, subject);
    		rs = pst.executeQuery();
    		while(rs.next())
    			 blist.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getString(6),rs.getInt(7),rs.getInt(8)));
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
    public boolean modifyBookAvailCopies(byte ttype,int bookId)
    {
    	Connection con = null;
    	PreparedStatement pst = null;
    	int count =0;
    	String query = "update book set availcopies=availcopies-1 where bookid=?";
    	if(ttype==2) query = "update book set availcopies=availcopies+1 where bookid=?";
    	try
    	{
    		con = DBConnection.getConnection();
    		pst = con.prepareStatement(query);
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
    	return count ==1;
    }
    
    public String getBookTitleById(int bookId)
    {
    	Connection con = null;
    	PreparedStatement pst = null;
    	ResultSet rs = null;
    	String bookTitle = null;
    	try
    	{
    		con = DBConnection.getConnection();
    		pst = con.prepareStatement("select booktitle from book where bookid=?");
    		pst.setInt(1, bookId);
    		rs = pst.executeQuery();
    		if(rs.next())
    			bookTitle = rs.getString(1);
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
    	return bookTitle;
    }
   
}






/* public Book getBookDetailsByTitle(String title)
{
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	Book b = null;
	try
	{
		con = DBConnection.getConnection();
		pst = con.prepareStatement("select * from book where booktitle=?");
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
}*/
