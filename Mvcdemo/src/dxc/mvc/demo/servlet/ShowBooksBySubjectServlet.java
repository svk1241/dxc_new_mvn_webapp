package dxc.mvc.demo.servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dxc.mvc.demo.bean.Book;
import dxc.mvc.demo.dao.BookDAO;
@WebServlet("/ShowBooksBySubjectServlet")
public class ShowBooksBySubjectServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		String topic = request.getParameter("subject");
		ArrayList<Book> blist = new BookDAO().getBooksBySubject(topic);
		request.setAttribute("booklist", blist);
		//RequestDispatcher rd = request.getRequestDispatcher("DisplayBooks.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("JstlDemo.jsp");
		rd.forward(request, response);
	}
	

}
