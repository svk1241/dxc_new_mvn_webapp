package dxc.web.lib2.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dxc.web.lib2.bean.Member;
import dxc.web.lib2.service.BookService;
import dxc.web.lib2.service.MemberService;
import dxc.web.lib2.service.TransactionService;


@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String txt1 = request.getParameter("memberId");
    	String txt2 = request.getParameter("bookId");
    	int memberId = 0, bookId =0;
    	if(txt1!=null && txt1.length()!=0) memberId =Integer.parseInt(txt1);
    	if(txt2!=null && txt2.length()!=0) bookId =Integer.parseInt(txt2);
    	String submitButton = request.getParameter("checkout");
    	TransactionService tService = new TransactionService();
    	//BookService bService = new BookService();
    	MemberService mService = new MemberService();
    	Member m = null;
    	switch(submitButton)
    	{
    	case "getDetails":
    		request.setAttribute("transObj", tService.getTransactionByMemberId(memberId));
    	      m = mService.showMemebr(memberId);
    		request.setAttribute("memberObj",m);
    		request.getSession().setAttribute("memberId", memberId);
    		break;
    	case "Return Book":
    		Integer memId = (Integer)request.getSession().getAttribute("memberId");
    		if(memId!=null) tService.checkOut(memId,bookId);
    	
    	}
    	 request.getRequestDispatcher("CheckOut.jsp").forward(request, response);
	}

	
	
    
    
    
    
    
    
    
    
    
    
    //protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	//}

}
