package com.assignment.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="salaries")
public class Salary {
	
	@Column(name="salary", nullable=false)
	private Integer salary;
	
	@OneToOne(targetEntity=Employee.class)  
	private Employee employee;

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
}
