package dxc.jsp.demo.dao;
import java.sql.*;
public class UsersDAO 
{
	public boolean searchUser(String username,String password)
	{
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/svk","root","1999");
			pst = con.prepareStatement("select count(*) from users where username=? and password=?");
			pst.setNString(1, username);  pst.setNString(2, password);
            rs= pst.executeQuery();
            if(rs.next()) count =rs.getInt(1);
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
		return count == 1;

}
}
