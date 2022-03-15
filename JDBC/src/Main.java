import java.sql.*;
public class Main {

	public static void main(String[] args)
	{
		Connection con = null;
		PreparedStatement pst = null;
		String url="jdbc:mysql://localhost:3306/svk";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
	        con=DriverManager.getConnection(url,"root","1999");
	        //con.setAutoCommit(false);
	        pst =con.prepareStatement("insert into employee values(?,?,?)");
		    pst.setInt(1, 103); pst.setString(2, "ram"); pst.setDouble(3, 25000);
		    int count = pst.executeUpdate();
		    System.out.println(count +" rows inserted ");
		    //con.commit();
		    pst =con.prepareStatement("insert into employee values(?,?,?)");
		    pst.setInt(1, 104); pst.setString(2, "raju"); pst.setDouble(3, 2000);
		    count = pst.executeUpdate();
		    System.out.println(count +" rows inserted ");
		    //con.rollback();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			try
			{
				
				if(pst!=null) pst.close();
				if(con!=null) con.close();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
	}
}