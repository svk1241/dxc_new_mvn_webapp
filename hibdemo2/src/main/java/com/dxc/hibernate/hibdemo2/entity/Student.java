package com.dxc.hibernate.hibdemo2.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class Student
{
	@Id
	@Column(name="sid")
	int studentId;
	@Column(name="sname")
	String studentName;
	long phone;
	@ManyToMany(fetch =FetchType.EAGER)
	@JoinTable(name="student_course_registration",joinColumns=@JoinColumn(name="sid"),inverseJoinColumns=@JoinColumn(name="Cid"))
	List<Course> clist;
	public Student() { }
	public Student(int studentId, String studentName, long phone) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.phone = phone;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public List<Course> getClist() {
		return clist;
	}
	public void setClist(List<Course> clist) {
		this.clist = clist;
	}
	

}
