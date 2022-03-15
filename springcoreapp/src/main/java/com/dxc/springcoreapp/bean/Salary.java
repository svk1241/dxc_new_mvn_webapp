package com.dxc.springcoreapp.bean;

public class Salary
{
	double hra;
	double dA;
	double basic;
	public Salary() { }
	public Salary(double hra, double dA, double basic) {
		super();
		this.hra = hra;
		this.dA = dA;
		this.basic = basic;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public double getdA() {
		return dA;
	}
	public void setdA(double dA) {
		this.dA = dA;
	}
	public double getBasic() {
		return basic;
	}
	public void setBasic(double basic) {
		this.basic = basic;
	}
	
	

}
