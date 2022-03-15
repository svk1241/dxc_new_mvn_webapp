package dxc.web.lib2.service;
import dxc.web.lib2.dao.MemberDAO;
import dxc.web.lib2.bean.Member;
import java.util.ArrayList;
public class MemberService 
{
	MemberDAO mdao = new MemberDAO();
	public Member showMemebr(int memberId)
	{
		return mdao.getMemberDetails(memberId);
	}
	public boolean addMember(Member m)
	{
		return mdao.insertMemberDetails(m);
	}
	public boolean deleteMember(int memberId)
	{
		return mdao.deleteMemberDetails(memberId);
	}
	public boolean modifyMember(Member m)
	{
		return mdao.modifyMemberDetails(m);
	}
	public ArrayList<Member> showAllMembers()
	{
		return mdao.getAllMemberDetails();
	}

}
