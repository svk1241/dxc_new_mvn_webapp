package dxc.web.lib2.dao;
import dxc.web.lib2.bean.Member;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class MemberDAO 
{
	 public  boolean insertMemberDetails(Member m)
	 {
		 Connection con=null;
		 PreparedStatement pst =null;
		 int count =0;
		 try
		 {
			 con =DBConnection.getConnection();
			 pst=con.prepareStatement("insert into member value(?,?,?,?,?)");
			 pst.setInt(1, m.getMemberId()); pst.setString(2, m.getName());
			 pst.setString(3,  m.getAadaharNo()); pst.setLong(4,  m.getPhone());
			 pst.setNString(5,  m.getEmailId());
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
			return count==1;
		 
	 }
	 
	 public  boolean modifyMemberDetails(Member m)
	 {
		 Connection con=null;
		 PreparedStatement pst =null;
		 int count =0;
		 try
		 {
			 con =DBConnection.getConnection();
			 pst=con.prepareStatement("update member set phone=?,emailid=? where memberid=?");
			 pst.setLong(1, m.getPhone()); pst.setString(2, m.getEmailId());
			 pst.setInt(3,  m.getMemberId()); 
			 count = pst.executeUpdate();
		 }
		 catch(Exception ex)
			{
				 ex.printStackTrace();
			}
			finally
			{
				if(pst!=null) DBConnection.closeStatement(pst);
				
			    if(con!=null)DBConnection.closeConnection(con);
				
			}
			return count==1;
		 
	 }
	 public  boolean deleteMemberDetails(int memberId)
	 {
		 Connection con=null;
		 PreparedStatement pst =null;
		 int count =0;
		 try
		 {
			 con =DBConnection.getConnection();
			 pst=con.prepareStatement("delete from member  where memberid=?");
			 pst.setInt(1,memberId); 
			 count = pst.executeUpdate();
		 }
		 catch(Exception ex)
			{
				 ex.printStackTrace();
			}
			finally
			{
				if(pst!=null) DBConnection.closeStatement(pst);
				
			    if(con!=null)DBConnection.closeConnection(con);
				
			}
			return count==1;
		 
	 }
	 public Member getMemberDetails(int memberId)
		{
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			Member m = null;
			try
			{
				con = DBConnection.getConnection();
				pst = con.prepareStatement("select * from member where memberid=?");
				pst.setInt(1, memberId);
				rs= pst.executeQuery();
				if(rs.next())
					m = new Member(memberId,rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5));
				
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
			return m;
		}
	 public  ArrayList<Member>getAllMemberDetails()
	 {
		 Connection con=null;
		 PreparedStatement pst =null;
		 ResultSet rs=null;
		 ArrayList<Member> mlist=new ArrayList<>();
		 try
		 {
			 con =DBConnection.getConnection();
			 pst=con.prepareStatement("select *from member ");
			 rs=pst.executeQuery();
			 while(rs.next())
				 mlist.add(new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getLong(4),rs.getString(5)));
			 
			 
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
			return mlist;
		 
	 }
}











         