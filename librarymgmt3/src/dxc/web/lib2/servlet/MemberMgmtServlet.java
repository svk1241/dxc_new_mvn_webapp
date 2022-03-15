package dxc.web.lib2.servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dxc.web.lib2.bean.Member;
import dxc.web.lib2.service.MemberService;
@WebServlet("/MemberMgmtServlet")
public class MemberMgmtServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	Member m = new Member();
    	m.setMemberId(Integer.parseInt(request.getParameter("memberId")));
    	m.setName(request.getParameter("memname"));
    	m.setAadaharNo(request.getParameter("adhno"));
    	m.setPhone(Long.parseLong(request.getParameter("mobile")));
    	m.setEmailId(request.getParameter("emailId"));
    	String submitButton = request.getParameter("memberbutton");
    	request.setAttribute("memberObj", new Member());
		RequestDispatcher rd = request.getRequestDispatcher("MemberDetails.jsp");
		MemberService mService = new MemberService();
		switch(submitButton)
		{
		case "Add":
			mService.addMember(m);
			break;
		case "Delete":
			mService.deleteMember(m.getMemberId());
			break;
		case "Modify":
			mService.modifyMember(m);
			break;
		case "Show":
			m = mService.showMemebr(m.getMemberId());
			request.setAttribute("memberObj", m);
			break;
		default:
				ArrayList<Member> mList=mService.showAllMembers();
				//System.out.println(mList.size());
			    request.setAttribute("memberList", mList);
			
		} 
		rd.forward(request, response);
		
	}

}
