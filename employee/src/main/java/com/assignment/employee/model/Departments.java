package com.assignment.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Departments {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="dept_no", nullable=false, length=4)
	private Integer departmentNo;
	
	@Column(name="dept_name", nullable=false, unique = true, length=40)
	private String departmentName;
	
	@ManyToOne
	private Employee employee;

	public Integer getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(Integer departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
}
