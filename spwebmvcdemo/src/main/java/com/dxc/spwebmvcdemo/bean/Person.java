package com.dxc.spwebmvcdemo.bean;
import org.springframework.stereotype.Component;
@Component
public class Person
{
	int ssn;
	String name;
	int age;
	char gender;
	String [] education;
	public Person() { }
	public Person(int ssn, String name, int age, char gender, String[] education) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.education = education;
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String[] getEducation() {
		return education;
	}
	public void setEducation(String[] education) {
		this.education = education;
	}
	
	
	

}
