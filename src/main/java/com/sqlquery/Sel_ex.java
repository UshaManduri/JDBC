package com.sqlquery;

public class Sel_ex {
	private Long emp_id;
	private String name;
	private Double salary;
	public Long getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
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
		return "Sel_ex [emp_id=" + emp_id + ", name=" + name + ", salary=" + salary + "]";
	}
}
