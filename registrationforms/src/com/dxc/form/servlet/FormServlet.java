package com.dxc.form.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.form.bean.WebForm;
import com.dxc.form.service.FormService;
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		WebForm f = new WebForm();
		f.setName(request.getParameter("name"));
		f.setEmail(request.getParameter("email"));
		f.setWebsite(request.getParameter("website"));
		f.setMessage(request.getParameter("message"));
		String submitButton =request.getParameter("formSubmit");
		FormService fs = new FormService();
		request.setAttribute("form", new WebForm());
		switch(submitButton)
		{
		case "Submit":
			fs.addDetails(f);
			System.out.println("came");
			
		
		
		
		
		}
		RequestDispatcher rd = request.getRequestDispatcher("webForm1.jsp");
		rd.forward(request, response);
	
	}

	
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}*/

}
