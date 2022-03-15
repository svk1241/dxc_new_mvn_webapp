package com.dxc.hibernate.hibdemo2.entity;
import com.dxc.hibernate.hibdemo2.entity.Student;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course 
{
	@Id
	@Column(name="cid")
	int courseId;
	@Column(name="cname")
	String courseName;
	int duration;
	double fee;
	//@ManyToMany(mappedBy="clist")
	@ManyToMany(mappedBy="clist",fetch =FetchType.EAGER)
	List<Student> slist;
	public Course() { }
	public Course(int courseId, String courseName, int duration, double fee) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.fee = fee;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public List<Student> getSlist() {
		return slist;
	}
	public void setSlist(List<Student> slist) {
		this.slist = slist;
	}
	
	

}
