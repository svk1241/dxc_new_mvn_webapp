package com.dxc.employeedetails.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.employeedetails.bean.Employee;
import com.dxc.employeedetails.dao.EmployeeDAO;
import com.dxc.employeedetails.service.EmployeeService;







@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 Employee e = new Employee();
		

  	   e.setId(Integer.parseInt(request.getParameter("id")));
  	   e.setName(request.getParameter("name"));
  	   String employeeSubmit = request.getParameter("empSubmit");
  	   EmployeeService eService = new EmployeeService();
  	 
  	  // Employee e1=(Employee)request.getAttribute("Employee");
		//if(e1==null) e1=new Employee();
  	   request.setAttribute("employee", new Employee());
  	   switch(employeeSubmit)
  	   {
  	    case "submit":
  	    	
  	    	eService.addEmployee(e);
  	    	//System.out.println("came");
  	    	break;
  	    case "showAll":
	    	ArrayList<Employee> elist = eService.getAllEmployees();
	    	request.setAttribute("empList", elist);
	    	System.out.println("came");
  	  
  	   
  	
  	   }
  	   RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
  	   rd.forward(request,response);
  	   
	}
		
	}


