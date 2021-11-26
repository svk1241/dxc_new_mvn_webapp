package com.dxc.employeedetails.service;

import java.util.ArrayList;

import com.dxc.employeedetails.bean.Employee;
import com.dxc.employeedetails.dao.EmployeeDAO;





public class EmployeeService 
{

	 EmployeeDAO edao = new EmployeeDAO();
	 public boolean addEmployee(Employee e)
	   {
		   return edao.insertEmployeeDetails(e);
	   }
	 public ArrayList<Employee> getAllEmployees()
	   {
		  System.out.println("working");
		  return edao.getAllEmployeeDetails();
		  
	   }
	 

}
