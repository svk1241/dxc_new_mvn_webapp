package com.dxc.springcoreapp.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.inject.Named;
import javax.inject.Inject;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
//@Component
//@Service
@Named
@Scope("prototype")
public class Person
{
	int ssn=7002;
	String name="sri";
	
	Address address;
	public Person() { }
	@Inject
	public Person(Address address)
	{
		System.out.println("Hello");
		this.address=address;
	}
	public Person(int ssn, String name, Address address) 
	{
		System.out.println("hi");
		this.ssn = ssn;
		this.name = name;
		this.address = address;
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
	
	public Address getAddress() {
		return address;
	}
	//@Autowired
	//@Qualifier("add2")
	public void setAddress(Address address) {
		this.address = address;
	}
	@PostConstruct
	public void initPerson()
	{
		System.out.println("from init");
	}
	@PreDestroy()
	public void destroyPerson()
	{
		System.out.println("from destroy");
	}
	
	

}
