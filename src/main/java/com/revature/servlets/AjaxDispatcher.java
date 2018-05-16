package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daoservice.EmployeeDaoService;
import com.revature.daoservice.ReimbursementDaoService;

public class AjaxDispatcher {

	private AjaxDispatcher() {}
	
	public static Object process(HttpServletRequest request, HttpServletResponse response) {
		
		switch(request.getRequestURI()) {
		
		case "/ProjectOneWeb/getAllEmployees.ajax": 
			System.out.println("run inside employeelist ajax");
			return EmployeeDaoService.getAllEmployees();
		
		case "/ProjectOneWeb/getAllManagers.ajax": 
			System.out.println("run inside managerlist ajax");
			return EmployeeDaoService.getAllManagers();
			

		
		default: return new String("Not implemented");
		}
	}
}
