package dxc.web.lib2.servlet;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import dxc.web.lib2.bean.Book;
import dxc.web.lib2.dao.BookDAO;
import dxc.web.lib2.service.BookService;
@WebServlet("/BookMgmtServlet")
   public class BookMgmtServlet extends HttpServlet 
   {
	private static final long serialVersionUID = 1L;
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
    	   Book b = new Book();
    	   b.setBookId(Integer.parseInt(request.getParameter("bookId")));
    	   b.setBookTitle(request.getParameter("booktitle"));
    	   b.setAuthor(request.getParameter("author"));
    	   b.setPublisher(request.getParameter("publisher"));
    	   b.setPrice(Double.parseDouble(request.getParameter("price")));
    	   b.setSubject(request.getParameter("subject"));
    	   b.setTotalCopies(Integer.parseInt(request.getParameter("copies")));
    	   String submitButton = request.getParameter("bookSubmit");
    	   BookService bService = new BookService();
    	   request.setAttribute("book", new Book());
    	   switch(submitButton)
    	   {
    	    case "Add":
    	    	bService.addBook(b);
    	    	break;
    	    case "Delete":
    	    	bService.deleteBook(b.getBookId());
    	    	break;
    	    case "Modify":
    	    	bService.modifyBook(b);
    	    	break;
    	    case "Show":
    	    	b=bService.getBook(b.getBookId());
    	    	request.setAttribute("book",b);
    	    	break;
    	    case "ShowAll":
    	    	ArrayList<Book> blist = bService.getAllBooks();
    	    	request.setAttribute("bookList", blist);
    	
    	   }
    	   RequestDispatcher rd = request.getRequestDispatcher("BookDetails.jsp");
    	   rd.forward(request,response);
    	   
	}

}
