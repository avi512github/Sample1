package com.assignment.employee.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dept_emp")
public class DepartmentEmployee {

	@Column(name="from_date", nullable=false)
	private LocalDateTime fromDate;

	@Column(name="to_date", nullable=false)
	private LocalDateTime toDate;
	
	@OneToOne(targetEntity=Employee.class)  
	private Employee employee;
	
	@OneToOne(targetEntity=Employee.class)
	private Departments department;
	
	

	public LocalDateTime getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDateTime fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDateTime getToDate() {
		return toDate;
	}

	public void setToDate(LocalDateTime toDate) {
		this.toDate = toDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}
	
	
}
