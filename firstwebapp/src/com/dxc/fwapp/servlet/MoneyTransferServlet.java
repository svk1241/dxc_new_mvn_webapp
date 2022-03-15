package com.dxc.fwapp.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dxc.fwapp.dao.AccountsDAO;
@WebServlet("/MoneyTransferServlet")
public class MoneyTransferServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	//String username = request.getParameter("username");
    	/*String username = null;
    	Cookie[] carr = request.getCookies();
    	for(Cookie c : carr)
    		if(c.getName().equals("username"))
    			username = c.getValue(); */
    	HttpSession session = request.getSession();
    	String username = (String)session.getAttribute("uid");
    	double amount = Double.parseDouble(request.getParameter("amount"));
    	AccountsDAO adao= new AccountsDAO();
    	double balance = adao.getAccountBalance(username);
    	//System.out.println(username);
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    	if(balance - amount >=0)
    	{
    		if(adao.modifyAccountBalance(username, amount, 'w'))
    		       out.print("Money Transfered Succesfully");
    		    else
    		    	out.print("Money Transfer Failed");
    		
    	}
    	else
    		 out.print("Transaction Rejected.....Insufficient Balance");
    }
		

}
