package com.revature.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daoservice.EmployeeDaoService;
import com.revature.model.Employee;

public class LoginService {

	private LoginService() {}
	
//	private static EmployeeDao dao = EmployeeDaoImpl.getInstance();

	
	public static String login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Employee new_employee = new Employee(username,password);
				
		// Login logic
		if(EmployeeDaoService.login(new_employee)) {
			Employee authorizedUser = EmployeeDaoService.getEmployee(username);
			request.getSession().setAttribute("authorizedUser", authorizedUser);
			return "/home.do";
		}
		
		return "/login.jsp";
	}
	
}
