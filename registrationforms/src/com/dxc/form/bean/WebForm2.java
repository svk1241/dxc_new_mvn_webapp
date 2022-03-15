package com.dxc.form.bean;

public class WebForm2 
{
	long userid;
	String password;
	String name;
	String address;
	String country;
	long zipcode;
	String email;
	String sex;
	String language;
	String about;
	public WebForm2() {}
	public WebForm2(long userid, String password, String name, String address, String country, long zipcode,
			String email, String sex, String language, String about) {
		super();
		this.userid = userid;
		this.password = password;
		this.name = name;
		this.address = address;
		this.country = country;
		this.zipcode = zipcode;
		this.email = email;
		this.sex = sex;
		this.language = language;
		this.about = about;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getZipcode() {
		return zipcode;
	}
	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	
	

}
