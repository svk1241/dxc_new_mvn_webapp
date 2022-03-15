import java.sql.*;
public class Main {

	public static void main(String [] args)
	{ 
		Connection con=null;
		Statement st=null;
		//ResultSet rs=null;
		String url="jdbc:mysql://localhost:3306/svk";
		try
		{
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  con=DriverManager.getConnection(url,"root","1999");
		  st=con.createStatement();
		  int count =st.executeUpdate("insert into employee values(104,'swa',1110)");
		  System.out.print(count +"rows inserted");
		  /*rs=st.executeQuery("select * from employee");
		  ResultSetMetaData rsmd= rs.getMetaData();
		  int count =rsmd.getColumnCount();
		  for(int i=1;i<=count;i++)
			  System.out.print(rsmd.getColumnName(i)+"  ");
		  System.out.println();
		  for(int i=1;i<=count;i++)
			  System.out.print(rsmd.getColumnTypeName(i)+"  ");
		  System.out.println();
		while(rs.next())  
		{
			for(int i=1;i<=count;i++)
				System.out.print(rs.getString(i)+"  ");
		
			  //System.out.print(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		   System.out.println();
	   }*/
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

	

