package com.dxc.mvnwebapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.mvnwebapp.bean.Users;
import com.dxc.mvnwebapp.dao.UsersDAO;


public class AuthenticateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    //protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getParameter("uid");
		String password = request.getParameter("pwd");
		Users u = new Users(username,password);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(new UsersDAO().validateUser(u))
			out.print("Welcome to the Maven Web Project");
		else
		{
			out.print("Invalid Username/Password");
			/*out.print("Invalid Login Credentials ....Try Once again");
			out.print("<hr>");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request,response);*/
			
		}
	}

}
