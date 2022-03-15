package com.dxc.hibernate.demo1.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("Hourly")
@Entity
public class HourlyEmployee extends Employee
{
	 int noOfHours;
	 double ratePerHour;
	public HourlyEmployee()
	{
		
	}
	public HourlyEmployee(int empid,String ename,int noOfHours, double ratePerHour) 
	{
		super(empid,ename);
		this.noOfHours = noOfHours;
		this.ratePerHour = ratePerHour;
	}
	public int getNoOfHours() {
		return noOfHours;
	}
	public void setNoOfHours(int noOfHours) {
		this.noOfHours = noOfHours;
	}
	public double getRatePerHour() {
		return ratePerHour;
	}
	public void setRatePerHour(double ratePerHour) {
		this.ratePerHour = ratePerHour;
	}
	
	 

}
