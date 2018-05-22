package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.daoservice.ReimbursementDaoService;
import com.revature.factory.Reimbursement;
import com.revature.factory.ReimbursementFactory;
import com.revature.model.Employee;


public class ReimbursementApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReimbursementApprovalServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee employee = (Employee) request.getSession().getAttribute("authorizedUser");
		
		String[] approval_rejection = request.getParameterValues("approval");
		List a__r_list =  Arrays.asList(approval_rejection); 
		request.setAttribute("approval", a__r_list);
		
		String reason = request.getParameter("reasongiven");
		
		
		for(Object reimbursementstring : a__r_list) {
			if(((String) reimbursementstring).startsWith("approved")) {
				System.out.println("Reimbursement with ID " +
						((String) reimbursementstring).substring(8,10) + " has been approved");
				
				Reimbursement updatereimbursement = ReimbursementFactory.getReimbursement(((String) reimbursementstring).substring(10));
				updatereimbursement.setId(Integer.parseInt(((String) reimbursementstring).substring(8, 10)));
				updatereimbursement = ReimbursementDaoService.getReimbursementFromId(updatereimbursement.getId());
				updatereimbursement.setApprover_id(employee.getId());
				
				updatereimbursement.setReason(reason);
				System.out.println(request.getParameter("reasongiven"));
				System.out.println(reason);
				System.out.println(updatereimbursement);
				
				System.out.print(ReimbursementDaoService.approveReimbursement(updatereimbursement));
			}
			else {
				System.out.println("Reimbursement with ID " +
						((String) reimbursementstring).substring(8,10) + " has been rejected");
				
				Reimbursement updatereimbursement = ReimbursementFactory.getReimbursement(((String) reimbursementstring).substring(10));
				updatereimbursement.setId(Integer.parseInt(((String) reimbursementstring).substring(8, 10)));
				updatereimbursement = ReimbursementDaoService.getReimbursementFromId(updatereimbursement.getId());
				updatereimbursement.setApprover_id(employee.getId());
				
				updatereimbursement.setReason(reason);
				System.out.println(request.getParameter("reasongiven"));
				System.out.println(reason);
				System.out.println(updatereimbursement);
				
				System.out.print(ReimbursementDaoService.rejectReimbursement(updatereimbursement));
			}
		}
		
		request.getRequestDispatcher("home.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
