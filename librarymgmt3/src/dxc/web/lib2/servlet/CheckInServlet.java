package dxc.web.lib2.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dxc.web.lib2.bean.Book;
import dxc.web.lib2.service.TransactionService;


@WebServlet("/CheckInServlet")
public class CheckInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	String subject = request.getParameter("subject");
    	String txt1 = request.getParameter("memberId");
    	String txt2 = request.getParameter("bookId");
    	int memberId =0,bookId=0;
    	if(txt1!=null && txt1.length()!=0) memberId = Integer.parseInt(txt1);
    	if(txt2!=null && txt2.length()!=0) bookId= Integer.parseInt(txt2);
    	String submitButton = request.getParameter("checkin");
    	TransactionService tService = new TransactionService();
    	if(submitButton.equals("Show Books"))
    		{
    		ArrayList<Book> blist =tService.getBooksBySubject(subject);
    		request.setAttribute("bookList", blist);
    		
    		}
    	else
    	{
    		tService.checkIn(memberId, bookId);
    	}
    	request.getRequestDispatcher("CheckIn.jsp").forward(request,response);
		
	}

}
