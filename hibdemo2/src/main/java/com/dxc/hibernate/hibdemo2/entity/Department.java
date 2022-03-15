package com.dxc.hibernate.hibdemo2.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Department 
{
	@Id
	@Column(name="dept_no")
	int departmentNo;
	@Column(name="dept_name")
	String departmentNmae;
	@Column(name="dept_loc")
	String departmentLocation;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="department")
   // @OneToMany
	//@JoinColumn(name="dept_no")
	List<Employee> elist;
	public Department() { }
	public Department(int departmentNo, String departmentNmae, String departmentLocation, List<Employee> elist) {
		super();
		this.departmentNo = departmentNo;
		this.departmentNmae = departmentNmae;
		this.departmentLocation = departmentLocation;
		this.elist = elist;
	}
	public int getDepartmentNo() {
		return departmentNo;
	}
	public void setDepartmentNo(int departmentNo) {
		this.departmentNo = departmentNo;
	}
	public String getDepartmentNmae() {
		return departmentNmae;
	}
	public void setDepartmentNmae(String departmentNmae) {
		this.departmentNmae = departmentNmae;
	}
	public String getDepartmentLocation() {
		return departmentLocation;
	}
	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
	public List<Employee> getElist() {
		return elist;
	}
	public void setElist(List<Employee> elist) {
		this.elist = elist;
	}
	
	

}
