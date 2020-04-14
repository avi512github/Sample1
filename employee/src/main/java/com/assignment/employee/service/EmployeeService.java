package com.assignment.employee.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.employee.exception.RecordNotFoundException;
import com.assignment.employee.model.Employee;
import com.assignment.employee.repository.EmployeeRepository;


@Service
public class EmployeeService{

	@Autowired
    private EmployeeRepository repository;

	public List<Employee> getAllEmployeesNameAndDobByDepartmentId(String departmentId) throws RecordNotFoundException {
		
		List<Employee> employeeList = repository.getAllEmployeesNameAndDobByDepartmentId(departmentId);
		
		if(employeeList.size()>0) {
            return employeeList;
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
	}

	public List<Employee> getAllEmployeesNamesHiredAfterDateAndMinSalaryIs(String particularDate, Integer minSalary)  throws Exception{
		
		//java.sql.Timestamp sq = new java.sql.Timestamp(particularDate.getTime());  

		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		List<Employee> employeeList = repository.getAllEmployeesNamesHiredAfterDateAndMinSalaryIs(particularDate, minSalary);
		
		if(employeeList.size()>0) {
            return employeeList;
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }

	}

	public void deleteEmployeeFromSalaryTblHavingHireDateBeforeGivenDate(Date hireDate, Date givenDate) throws RecordNotFoundException {
		
		java.sql.Timestamp sq = new java.sql.Timestamp(hireDate.getTime());  

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		java.sql.Timestamp sq1 = new java.sql.Timestamp(givenDate.getTime());  

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Employee> employeeList = repository.searchEmployeeFromSalaryTblHavingHireDateBeforeGivenDate(sdf.format(sq), sdf1.format(sq1));
        
		System.out.println(employeeList.size());
		
        if(employeeList.size()>0){
        	
        	for (Employee employee : employeeList) {
        		repository.deleteEmployeeFromSalaryTblHavingHireDateBeforeGivenDate(employee.getEmployeeNo());
			}  
        	
        	List<Employee> empList = repository.searchEmployeeFromSalaryTblHavingHireDateBeforeGivenDate(sdf.format(sq), sdf1.format(sq1));
        	
        	System.out.println(empList.size());
            
        } else {
            throw new RecordNotFoundException("No employee record exist for given id");
        }
	}
}
