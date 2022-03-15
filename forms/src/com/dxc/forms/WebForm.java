package com.dxc.forms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/WebForm")
public class WebForm extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList a = new ArrayList();
		String name=request.getParameter("name");
		/*String email =request.getParameter("email");
		String website = request.getParameter("website");
		String message = request.getParameter("message");*/
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		if ((name == null) || (name.equals(""))) {
            a.add("PROVIDE STUDENT NAME...");
		
		     
		    	  
	}

	

	}
}
