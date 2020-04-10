package com.assignment.employee.model;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="employees")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_no", nullable=false)
    private Integer employeeNo;
	
	@Column(name="birth_date", nullable=false)
    private LocalDateTime birthDate;
	
	@Column(name="first_name", nullable=false, length=14)
    private String firstName;

	@Column(name="last_name", nullable=false, length=16)
    private String lastName;

	@Column(name="gender", nullable=false)
    private Gender gender;  

	@Column(name="hire_date", nullable=false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date hireDate;
	
	@OneToOne
	private Departments department;
	
	@OneToOne(targetEntity=Salary.class,cascade=CascadeType.ALL)
	private Salary salary;
	
	

	public Employee(String firstName, String lastName, LocalDateTime localDateTime) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = localDateTime;
	}

	public Integer getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(Integer employeeNo) {
		this.employeeNo = employeeNo;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}
	
	
    
    
}
