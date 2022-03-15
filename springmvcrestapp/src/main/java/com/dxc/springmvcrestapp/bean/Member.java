package com.dxc.springmvcrestapp.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Member {
	@Id
   private int memberId;
   private String name;
   private String aadharNo;
   private long phone;
   private String emailId;
   public Member() { }
public Member(int memberId, String name, String aadharNo, long phone, String emailId) {
	super();
	this.memberId = memberId;
	this.name = name;
	this.aadharNo = aadharNo;
	this.phone = phone;
	this.emailId = emailId;
}
public int getMemberId() {
	return memberId;
}
public void setMemberId(int memberId) {
	this.memberId = memberId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAadharNo() {
	return aadharNo;
}
public void setAadharNo(String aadharNo) {
	this.aadharNo = aadharNo;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
   
}