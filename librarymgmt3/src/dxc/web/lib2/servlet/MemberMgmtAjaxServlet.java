package dxc.web.lib2.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dxc.web.lib2.bean.Member;
import dxc.web.lib2.service.MemberService;
@WebServlet("/MemberMgmtAjaxServlet")
public class MemberMgmtAjaxServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	Member m = new Member();
    	String memId = request.getParameter("memberId");
    	if(memId!=null)m.setMemberId(Integer.parseInt(memId));
    	m.setName(request.getParameter("memname"));
    	m.setAadaharNo(request.getParameter("adhno"));
    	String mobile = request.getParameter("mobile");
    	if(mobile!=null)m.setPhone(Long.parseLong(mobile));
    	m.setEmailId(request.getParameter("emailId"));
    	String submitButton = request.getParameter("memberbutton");
    	request.setAttribute("memberObj", new Member());
		//RequestDispatcher rd = request.getRequestDispatcher("MemberDetails.jsp");
		MemberService mService = new MemberService();
		String message = "";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		switch(submitButton)
		{
		case "Add":
			if(mService.addMember(m)) message ="Added Successfully";
			else message = " Added Failed";
				
			break;
		case "Delete":
			if(mService.deleteMember(m.getMemberId())) message ="Deleted Succesfully";
			else message = " Deletion Failed";
			break;
		case "Modify":
			if(mService.modifyMember(m)) message ="Modified Succesfully";
			else message = "Modification Failed";
			break;
		case "Show":
			m = mService.showMemebr(m.getMemberId());
			out.print("{\"memberId\":"+m.getMemberId()+",\"name\":\""+m.getName()+"\",\"aadharNo\":\""+m.getAadaharNo()+"\",\"phone\":"+m.getPhone()+",\"emailId\":\""+m.getEmailId()+"\"}");

			//request.setAttribute("memberObj", m);
			break;
		default:
				ArrayList<Member> mList=mService.showAllMembers();
				//System.out.println(mList.size());
			    //request.setAttribute("memberList", mList);
				String xmlObjs = "<Members>";
				for(Member m1 : mList)
				{ 
					xmlObjs = xmlObjs+"<Member>";
					xmlObjs =xmlObjs+"<memberId>"+m1.getMemberId()+"</memberId>";
					xmlObjs =xmlObjs+"<name>"+m1.getName()+"</name>";
					xmlObjs =xmlObjs+"<aadharNo>"+m1.getAadaharNo()+"</aadharNo>";
					xmlObjs =xmlObjs+"<phone>"+m1.getPhone()+"</phone>";
					xmlObjs =xmlObjs+"<emailId>"+m1.getEmailId()+"</emailId>";
					xmlObjs = xmlObjs+"</Member>";
				}
				xmlObjs = xmlObjs+"</Members>";
				
				out.print(xmlObjs);
			
		} 
		out.print(message);
		
	}

}
