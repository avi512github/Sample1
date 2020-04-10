package com.assignment.employee.repository;

import java.util.Date;
import java.util.List;

import com.assignment.employee.model.Employee;

public interface EmployeeRepository {

	List<Employee> getAllEmployeesNameAndDobByDepartmentId(String departmentId);

	List<Employee> getAllEmployeesNamesHiredAfterDateAndMinSalaryIs(String particularDate, Integer minSalary);

	List<Employee> searchEmployeeFromSalaryTblHavingHireDateBeforeGivenDate(String hireDate, String givenDate);

	Integer deleteEmployeeFromSalaryTblHavingHireDateBeforeGivenDate(Integer employeeNo);

}
