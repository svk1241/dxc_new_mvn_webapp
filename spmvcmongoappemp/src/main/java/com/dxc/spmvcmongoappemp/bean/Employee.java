package com.dxc.spmvcmongoappemp.bean;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee 
{
	@Id
	ObjectId id;
	int empno;
	String ename;
	String emailId;
	long phone;
	double salary;
	public Employee() {}
	public Employee(int empno, String ename, String emailId, long phone, double salary) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.emailId = emailId;
		this.phone = phone;
		this.salary = salary;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	

}
