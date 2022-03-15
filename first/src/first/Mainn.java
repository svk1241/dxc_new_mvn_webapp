import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;
public class Main {

	public static void main(String [] args)
	{ 
		Connection con=null;
		CallableStatement cst=null;
		//Statement st=null;
		//ResultSet rs=null;
		String url="jdbc:mysql://localhost:3306/svk";
		try
		{
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  con=DriverManager.getConnection(url,"root","1999");
		  cst=con.preparecall("call AddaMasterDeatils(?,?,?)select *from employee");
		  cst.setInteger(1, 7001);  cst.setNString(2, "miller"); cst.setDouble(3, 25000);
		  System.out.print(count +"rows inserted");
		  
	} 
	catch(Exception ex)
		{
			System.out.println(ex);
		
		}
		finally
		{
			 try
			 {
				 if(rs!=null)rs.close();
				 if(st!=null)st.close();
				 if(con!=null)con.close();
				 
			 }
			 catch(Exception ex)
			 {
				 System.out.println(ex);
			 }
				 
			 }
		}
	}
