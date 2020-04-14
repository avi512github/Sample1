package com.assignment.employee.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.employee.exception.RecordNotFoundException;
import com.assignment.employee.model.Employee;
import com.assignment.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	  @Autowired private EmployeeService employeeService;
	  
	  
	  
	  @GetMapping("/department/{id}") 
	  public ResponseEntity<List<Employee>> getAllEmployeesNameAndDobByDepartmentId(@PathVariable("id") String departmentId) throws RecordNotFoundException { 
		  List<Employee> list = employeeService.getAllEmployeesNameAndDobByDepartmentId(departmentId);
	  
		  return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK); 
	  }
	  
	  @GetMapping("hiredate/{date}/salary/{minSalary}") 
	  public ResponseEntity<List<Employee>> getAllEmployeesNamesHiredAfterDateAndMinSalaryIs(@PathVariable("date") String particularDate, @PathVariable("minSalary") Integer minSalary) throws Exception { 
		  List<Employee> list = employeeService.getAllEmployeesNamesHiredAfterDateAndMinSalaryIs(particularDate, minSalary);
	  
		  return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK); 
	  }
	  
	  
	  @DeleteMapping("/hireDate/{hireDate}/givenDate/{givenDate}") 
	  public HttpStatus deleteEmployeeFromSalaryTblHavingHireDateBeforeGivenDate(@PathVariable("hireDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date hireDate, @PathVariable("givenDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date givenDate) throws RecordNotFoundException {
		  	
		  employeeService.deleteEmployeeFromSalaryTblHavingHireDateBeforeGivenDate(hireDate, givenDate); 
		  	
		  return HttpStatus.OK; 
	  }
	 
}
