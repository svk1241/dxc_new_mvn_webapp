package com.dxc.hibernate.hibdemo2.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="passport")
public class Passport 
{
	@Id
	@Column(name="passport_no")
	String passportNo;
	@Column(name="issue_authority")
	String issueAuthority;
	@Column(name="issued_date")
	LocalDate issusedDate;
	@Column(name="expire_date")
	LocalDate expireDate;
	@OneToOne(mappedBy="passport")
	Person person;
	public Passport() { }
	public Passport(String passportNo, String issueAuthority, LocalDate issusedDate, LocalDate expireDate) {
		this.passportNo = passportNo;
		this.issueAuthority = issueAuthority;
		this.issusedDate = issusedDate;
		this.expireDate = expireDate;
	}
	public String getPassportNo() {
		return passportNo;
	}
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	public String getIssueAuthority() {
		return issueAuthority;
	}
	public void setIssueAuthority(String issueAuthority) {
		this.issueAuthority = issueAuthority;
	}
	public LocalDate getIssusedDate() {
		return issusedDate;
	}
	public void setIssusedDate(LocalDate issusedDate) {
		this.issusedDate = issusedDate;
	}
	public LocalDate getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(LocalDate expireDate) {
		this.expireDate = expireDate;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	

}
