package com.revature.daoservice;


import java.util.List;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
import com.revature.logs.LogHere;
import com.revature.model.Employee;

public class EmployeeDaoService {

	private static EmployeeDao dao = EmployeeDaoImpl.getInstance();
	
	private EmployeeDaoService() {}
	
	public static List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}
	
	public static List<Employee> getAllManagers() {
		return dao.getAllManagers();
	}
	
	public static Employee getEmployee(String username) {
		return dao.getEmployee(username);
	}
	
	public static Employee getAnyEmployee() {
		return dao.getAnyEmployee();
	}

	public static boolean insertEmployee(Employee user) {
		return dao.insertEmployee(user);
	}
	
	public static boolean updateEmployee(Employee user) {
		return dao.updateEmployee(user);
	}
	
	
	public static boolean login(Employee employee) {
		Employee newemployee = dao.getEmployee(employee.getUsername());
		
		try {		
			
			if(newemployee.getPassword().equals(dao.getPasswordHash(employee))){
				System.out.println("You are a valid user, " + newemployee.getUsername());
				return true;
			}
		} catch(NullPointerException npe) {
			LogHere.warn(npe.getMessage());
			System.out.println("The username or password combination is invalid.");
			return false;
		}

		System.out.println("The username or password combination is invalid.");
		return false;
	}
	
}
