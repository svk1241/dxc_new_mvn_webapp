package com.dxc.hibernate.hibdemo2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person 
{
	@Id
	int ssn;
	String name;
	int age;
	@OneToOne
	@JoinColumn(name="passport_no")
	Passport passport;
	public Person() { }
	public Person(int ssn, String name, int age, Passport passport) {
		this.ssn = ssn;
		this.name = name;
		this.age = age;
		//this.passport = passport;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
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
	public Passport getPassport() {
		return passport;
	}
	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	

}
