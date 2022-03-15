package com.dxc.employeedetails.bean;

public class EmployeeDetails 
{
	int id;
	String name;
	public EmployeeDetails() {}
	public EmployeeDetails(int id, String name) {
	
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	};
	
	
	
	
	

}
