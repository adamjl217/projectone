package com.revature.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.revature.daoservice.ReimbursementDaoService;
import com.revature.factory.Reimbursement;
import com.revature.factory.ReimbursementFactory;
import com.revature.model.Employee;

@MultipartConfig
public class ReimbursementService {

	public static String insertreimbursement(HttpServletRequest request, HttpServletResponse response) {

		
			try {
				Employee employee = (Employee) request.getSession().getAttribute("authorizedUser");
				
				String new_category = getValue(request.getPart("categoryselect"));
				String new_amount = getValue(request.getPart("reimbursementamount"));
				
				Part image_part =  request.getPart("receiptimage");
				
				InputStream new_image =  image_part.getInputStream();
				
				Reimbursement newreimbursement = ReimbursementFactory.getReimbursement(new_category.toLowerCase());
				newreimbursement.setRequestor_id(employee.getId());
				newreimbursement.setAmount(Double.parseDouble(new_amount));
				newreimbursement.setImage(new_image);
				
				System.out.println(ReimbursementDaoService.insertReimbursement(newreimbursement));

			} catch (IOException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			}

		return "/reimbursementpage.jsp";
	}
	
	private static String getValue(Part part) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(part.getInputStream(), "UTF-8"));
	    StringBuilder value = new StringBuilder();
	    char[] buffer = new char[1024];
	    for (int length = 0; (length = reader.read(buffer)) > 0;) {
	        value.append(buffer, 0, length);
	    }
	    return value.toString();
	}
	
	
	
}
