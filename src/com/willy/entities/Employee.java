package com.willy.entities;

import java.util.Set;

public class Employee {
	private int id;
	private String name;	   
	private int salary;
	private Set<Certificate> certificates;
	private int departmentId;
	
	public Employee() {}
	public Employee(String fname, int salary) {
		this.name = fname;	     
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId( int id ) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName( String first_name ) {
		this.name = first_name;
	}	   	   
	public int getSalary() {
		return salary;
	}
	public void setSalary( int salary ) {
		this.salary = salary;
	}

	public Set<Certificate> getCertificates() {
		return certificates;
	}
	public void setCertificates( Set<Certificate> certificates ) {
		this.certificates = certificates;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

}