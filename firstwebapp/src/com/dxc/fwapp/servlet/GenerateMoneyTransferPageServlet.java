package com.dxc.fwapp.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/GenerateMoneyTransferPageServlet")
public class GenerateMoneyTransferPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	response.setContentType("text/html");
    	PrintWriter out =response.getWriter();
    	out.print("<html><body>");
    	out.print("<form action ='MoneyTransferServlet'>");
    	out.print("<input type = hidden name = username value ="+request.getParameter("username")+" />");
    	out.print("<table width =50% align =center>");
    	out.print("<tr>");
    	out.print("<th>Destination Bank Name</th>");
    	out.print("<td> <input type = text name='dbn'></td>");
    	out.print("</tr>");
    	out.print("<tr>");
    	out.print("<th>Destination Bank Account No</th>");
    	out.print("<td> <input type = text name='dbacno'></td>");
    	out.print("</tr>");
    	out.print("<tr>");
    	out.print("<th>Amount to transfer</th>");
    	out.print("<td> <input type = text name='amount'></td>");
    	out.print("</tr>");
        out.print("<tr>");
    	out.print("<td> <input type = submit value='Transfer'></td>");
    	out.print("<td> <input type = reset value='Clear'></td>");
    	out.print("</tr>");
    	out.print("</table>");
    	out.print("</form>");
    	out.print("</body></html>");
    	
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	}


