package com.dxc.springcoreapp.bean;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import javax.inject.Named;
import javax.inject.Inject;

//@Component         //now  no need to creater <bean> for address class in .xml congig file
//@Repository
@Named
public class Address 
{
	String hno="1-121";
	String streetName="sri nagar";
	String city="Tuni";
	String state="Andhra pradesh";
	public Address() { }
	public Address(String hno, String streetName, String city, String state) {
	
		this.hno = hno;
		this.streetName = streetName;
		this.city = city;
		this.state = state;
	}
	public String getHno() {
		return hno;
	}
	public void setHno(String hno) {
		this.hno = hno;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	

}
