package com.revature.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daoservice.EmployeeDaoService;
import com.revature.logs.LogHere;
import com.revature.model.Employee;

public class EmployeeService {

	public static String updateemployee(HttpServletRequest request, HttpServletResponse response) {

		Employee employee = (Employee) request.getSession().getAttribute("authorizedUser");
		
		try {			
			if(request.getParameter("update_username") != "")
				employee.setUsername(request.getParameter("update_username"));
			
			if(request.getParameter("update_password") != "")
				employee.setPassword(request.getParameter("update_password"));
			
			if(request.getParameter("update_firstname") != "")
				employee.setFirstname(request.getParameter("update_firstname"));
			
			if(request.getParameter("update_lastname") != "")
				employee.setLastname(request.getParameter("update_lastname"));
			
			if(request.getParameter("update_email") != "")
				employee.setEmail(request.getParameter("update_email"));
						
			if(request.getParameter("update_phonenumer") != null)
				employee.setPhonenumber(Long.parseLong(request.getParameter("update_phonenumer")));
						
			System.out.println("Updated information? " + EmployeeDaoService.updateEmployee(employee));
			
		} catch(NullPointerException npe) {
			npe.getMessage();
		}
		
		return "/home.jsp";
	}

	public static String createemployee(HttpServletRequest request, HttpServletResponse response) {

		
		try {		
			Employee employee = new Employee();
			String managerstate = (String) request.getParameter("create_manager");
			if(managerstate.equals("T") || managerstate.equals("t") || managerstate.equals("true")) {
				employee.setManagerstatus(true);
			}
			employee.setUsername(request.getParameter("create_username"));
			employee.setPassword(request.getParameter("create_password"));
			employee.setFirstname(request.getParameter("create_firstname"));
			employee.setLastname(request.getParameter("create_lastname"));
			employee.setEmail(request.getParameter("create_email"));
			
			String phonenumstring = request.getParameter("create_phonenumber");
			employee.setPhonenumber(Long.valueOf(phonenumstring));
			
			System.out.println("Created employee? " + EmployeeDaoService.insertEmployee(employee));
		} catch(NullPointerException npe) {
			LogHere.warn(npe.getMessage());
			System.out.println(npe.getMessage());
		}
		
		return "/home.jsp";	
		
	}

	
}
