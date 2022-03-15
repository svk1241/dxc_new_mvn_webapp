package com.dxc.fwapp.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dxc.fwapp.bean.Users;
import com.dxc.fwapp.dao.UsersDAO;
@WebServlet(value="/AS",loadOnStartup=1,initParams= {@WebInitParam(name="first",value="first param"),@WebInitParam(name="second",value="678")})
//public class AuthenticateServlet extends GenericServlet
public class AuthenticateServlet extends HttpServlet
{
	//public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		//System.out.println("recived request from login.html");
		ServletConfig scon = getServletConfig();
		System.out.println(scon.getInitParameter("first"));
		System.out.println(scon.getInitParameter("second"));
		//ServletContext sctx = getServletContext();
		//System.out.println(sctx.getInitParameter("comPmt"));
		String username = req.getParameter("uid");
		String password = req.getParameter("pwd");
		//String results = "Invalid Username/Password";
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		Users u = new Users(username,password);
		RequestDispatcher rd=req.getRequestDispatcher("login.html");
		if(new UsersDAO().validateUser(u))
		{
			/*out.print("<h1>You are an Authorised User...welcome to website</h1>");
			out.print("<html><body>");
			
			out.print("<h1><a href = ' ' > Online Bill Payment</a></h1><br>");
			out.print("<h1><a href = 'GenerateMoneyTransferPageServlet?username="+username+" '>Online Money Transfer</a></h1><br>");
			out.print("<h1><a href = ' ' > Online Shopping</a></h1><br>");
			out.print("<h1><a href = ' ' > Load money Into EWallet</a></h1><br>");
			out.print("<h1><a href = ' ' > Abcxyz</a></h1><br>");
			out.print("</body></html>"); */
			/*Cookie c = new Cookie("username",username);
			res.addCookie(c);*/
			HttpSession session = req.getSession();
			session.setAttribute("uid",username);
			session.setMaxInactiveInterval(20);
			//session.invalidate(); kills the session
			rd = req.getRequestDispatcher("services.html");
			rd.forward(req, res);
			
		}
		else
		{   
			out.print("<h1>Invalid Username / Password</h1>");
			out.print("<hr>");
			//RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		
	}	

}
