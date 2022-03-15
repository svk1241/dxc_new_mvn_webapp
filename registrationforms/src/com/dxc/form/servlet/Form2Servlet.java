package com.dxc.form.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.form.bean.WebForm;
import com.dxc.form.bean.WebForm2;
import com.dxc.form.service.Form2Service;
import com.dxc.form.service.FormService;


@WebServlet("/Form2Servlet")
public class Form2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	//WebForm2 f = new WebForm2();
    	WebForm2 f = (WebForm2)request.getAttribute("form");
    	  if(f==null) f= new WebForm2();
    	f.setUserid(Long.parseLong(request.getParameter("userid")));
		f.setPassword(request.getParameter("password"));
		f.setName(request.getParameter("name"));
		f.setAddress(request.getParameter("address"));
		f.setCountry(request.getParameter("country"));
		f.setZipcode(Long.parseLong(request.getParameter("zipcode")));
		f.setEmail(request.getParameter("email"));
		f.setSex(request.getParameter("sex"));
		f.setLanguage(request.getParameter("language"));
		f.setAbout(request.getParameter("about"));
		String submitButton =request.getParameter("formSubmit");
		Form2Service fs = new Form2Service();
		request.setAttribute("form", new WebForm2());
		switch(submitButton)
		{
		case "Submit":
			fs.addDetails(f);
			System.out.println("came");
			
		
		
		
		
		}
		RequestDispatcher rd = request.getRequestDispatcher("webForm2.jsp");
		rd.forward(request, response);
	
	}
		
	}

	


