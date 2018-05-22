package com.revature.dao;

import java.util.List;

import com.revature.model.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees();
	List<Employee> getAllManagers();
	Employee getEmployee(String employeename);
	boolean insertEmployee(Employee employee);
	boolean updateEmployee(Employee employee);
	String getPasswordHash(Employee employee);
	Employee getAnyEmployee();
	
}
