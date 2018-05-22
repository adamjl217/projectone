package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.EmployeeService;
import com.revature.service.LoginService;
import com.revature.service.ReimbursementService;
import com.revature.service.UserService;

public class MasterDispatcher {

	private MasterDispatcher() {}
	
	public static String process(HttpServletRequest request, HttpServletResponse response) {
		switch(request.getRequestURI()) {
		case "/ProjectOneWeb/login.do":
			return LoginService.login(request, response);
		case "/ProjectOneWeb/home.do":
			return UserService.home(request, response);
		case "/ProjectOneWeb/rewreimbursement.do":
			return ReimbursementService.insertreimbursement(request, response);
		case "/ProjectOneWeb/update_employee.do":
			return EmployeeService.updateemployee(request, response);
		case "/ProjectOneWeb/create_employee.do":
			return EmployeeService.createemployee(request, response);
		default:
			return "404.jsp";
		}
	}
}
