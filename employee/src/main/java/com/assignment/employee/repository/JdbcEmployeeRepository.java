package com.assignment.employee.repository;

import java.sql.Types;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.assignment.employee.model.Employee;

@Repository
public class JdbcEmployeeRepository implements EmployeeRepository{

	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getAllEmployeesNameAndDobByDepartmentId(String departmentId) {
		
		return jdbcTemplate.query(
                "select emp.first_name, emp.last_name, emp.birth_date from employees emp, dept_emp dep  where emp.emp_no=dep.emp_no and dep.dept_no=?",
                new Object[]{departmentId},
                (rs, rowNum) ->
                        new Employee(
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getTimestamp("birth_date").toLocalDateTime()
                        )
        );
	}

	@Override
	public List<Employee> getAllEmployeesNamesHiredAfterDateAndMinSalaryIs(String particularDate, Integer minSalary) {
		
		return jdbcTemplate.query(
                "select emp.first_name, emp.last_name, emp.birth_date from employees emp, salaries sal  where emp.emp_no=sal.emp_no and to_char(emp.hire_date, 'yyyy-MM-dd')  < ? and sal.salary >= ?",
                new Object[]{"%" +  particularDate + "%", minSalary},
                (rs, rowNum) ->
                        new Employee(
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getTimestamp("birth_date").toLocalDateTime()
                        )
        );
	}

	@Override
	public List<Employee> searchEmployeeFromSalaryTblHavingHireDateBeforeGivenDate(String hireDate, String givenDate) {
		
		return jdbcTemplate.query(
                "select emp.emp_no, emp.first_name, emp.last_name, emp.birth_date from salaries sal, employees emp  where emp.emp_no=sal.emp_no and to_char(emp.hire_date, 'yyyy-MM-dd') > ? and to_char(emp.hire_date, 'yyyy-MM-dd') <= ?",
                new Object[]{"%" + hireDate + "%", givenDate},
                (rs, rowNum) ->
                        new Employee(
                                rs.getString("first_name"),
                                rs.getString("last_name"),
                                rs.getTimestamp("birth_date").toLocalDateTime()
                        )
        );
	}

	@Override
	public Integer deleteEmployeeFromSalaryTblHavingHireDateBeforeGivenDate(Integer employeeNo) {
		
		return jdbcTemplate.update(
                "delete employees where emp_no = ?",
                employeeNo);
	}
	 
	 
}
