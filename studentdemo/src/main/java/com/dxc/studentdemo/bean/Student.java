package com.dxc.studentdemo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student
{
	@Id
	int srNo;
	String name;
	int age;
	String address;
	long phone;
	public Student() { }
	public Student(int srNo, String name, int age, String address, long phone) {
		super();
		this.srNo = srNo;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	
}
