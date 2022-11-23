package com.pojo;


public class SelExample {
	
	private Long empId;
	private String name;
	private Double salary;
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "SelExample [empId=" + empId + ", name=" + name + ", salary=" + salary + "]";
	}
	
	

	
	
}
