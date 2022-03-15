package com.dxc.hibernate.hibdemo2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee
{
	@Id
	@Column(name="emp_no")
	int employeeNo;
	@Column(name="emp_name")
	String employeeName;
	double salary;
	@ManyToOne
	@JoinColumn(name="dept_no")
	Department department;
	public Employee() { }
	public Employee(int employeeNo, String employeeName, double salary) {
		
		this.employeeNo = employeeNo;
		this.employeeName = employeeName;
		this.salary = salary;
	}
	public int getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(int employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	

}
