package dxc.mvc.demo.dao;
import dxc.mvc.demo.bean.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class BookDAO 
{
	public ArrayList<Book>getBooksBySubject(String subjectName)
	{
		ArrayList<Book> blist = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/svk","root","1999");
			pst = con.prepareStatement("select * from book where subject =?");
			pst.setString(1, subjectName);;
			rs=pst.executeQuery();
			while(rs.next())
				blist.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5)));
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null) rs.close();
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
		return blist;
	}

}
