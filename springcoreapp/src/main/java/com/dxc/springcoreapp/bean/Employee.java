package com.dxc.springcoreapp.bean;

public class Employee extends Person
{
	int empId;
	String eName;
	double salary;
	public Employee() { }
	public Employee(int empId, String eName, double salary) {
		super();
		this.empId = empId;
		this.eName = eName;
		this.salary = salary;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}