package com.dxc.hibernate.demo1.entity;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Id;

@Entity
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
 @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="type")
public abstract class Employee
{
	@Id
	int empid;
	String ename;
	public Employee() { }
	public Employee(int empid, String ename) {
		this.empid = empid;
		this.ename = ename;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
    

}
