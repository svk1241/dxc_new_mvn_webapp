package com.dxc.fwapp.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//public  class DateServlet implements Servlet
@WebServlet("/DS")
//public  class DateServlet extends GenericServlet
public class DateServlet extends HttpServlet
{
	/* public void init(ServletConfig sc) throws ServletException
	{
		System.out.println(sc.getInitParameter("first"));
		
		//ServletContext context = sc.getServletContext();
		//System.out.println();
	} */
	
	//public void service(ServletRequest request,ServletResponse response) throws ServletException,IOException
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		ServletContext sctx = getServletContext();
		System.out.println(sctx.getInitParameter("comPmt"));
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");;
		out.print("<h1 style = color:red;text-align:center>");
		out.print(new java.util.Date());
		out.print("</h1>");
		out.print("</body></html>");
		System.out.println(request.getLocalName());
		System.out.println(request.getLocalPort());
		System.out.println(request.getProtocol());
		System.out.println(request.getRemoteAddr());
		System.out.println(request.getServerPort());
		System.out.println(request.getServerName());
		System.out.println(this.getInitParameter("first"));
	}
	/*public void destroy()
	{
		System.out.println("from destroy");
	}
	public String getServletInfo()
	{
		return " ";
	}
	
	@Override
	public ServletConfig getServletConfig() 
	{
		
		return this.getServletConfig();
	} */

}
