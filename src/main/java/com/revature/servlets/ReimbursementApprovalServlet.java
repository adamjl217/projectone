package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		String[] names = request.getParameterValues("approval");
		List list =  Arrays.asList(names); 
		request.setAttribute("approval", list);
		String reason_given = request.getParameter("reasongiven");
		
		for(Object reimbursementstring : list) {
			if(((String) reimbursementstring).startsWith("approved")) {
				System.out.println("Reimbursement with ID " +
						((String) reimbursementstring).substring(8,10) + " has been approved");
				
				Reimbursement updatereimbursement = ReimbursementFactory.getReimbursement(((String) reimbursementstring).substring(10));
				updatereimbursement.setId(Integer.parseInt(((String) reimbursementstring).substring(8, 10)));
				updatereimbursement = ReimbursementDaoService.getReimbursementFromId(updatereimbursement.getId());
				updatereimbursement.setApprover_id(employee.getId());
				updatereimbursement.setReason(reason_given);
				System.out.println(ReimbursementDaoService.approveReimbursement(updatereimbursement));
			}
			else {
				System.out.println("Reimbursement with ID " +
						((String) reimbursementstring).substring(8,10) + " has been rejected");
				
				Reimbursement updatereimbursement = ReimbursementFactory.getReimbursement(((String) reimbursementstring).substring(10));
				updatereimbursement.setId(Integer.parseInt(((String) reimbursementstring).substring(8, 10)));
				updatereimbursement = ReimbursementDaoService.getReimbursementFromId(updatereimbursement.getId());
				updatereimbursement.setApprover_id(employee.getId());
				updatereimbursement.setReason(reason_given);
				System.out.println(ReimbursementDaoService.rejectReimbursement(updatereimbursement));
			}
		}
		
		request.getRequestDispatcher("home_in.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
