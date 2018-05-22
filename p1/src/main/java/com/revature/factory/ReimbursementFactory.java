package com.revature.factory;

import com.revature.model.FoodReimbursement;
import com.revature.model.LodgingReimbursement;
import com.revature.model.OtherReimbursement;
import com.revature.model.TravelReimbursement;

public class ReimbursementFactory {

	public static Reimbursement getReimbursement(String category) {
		
		switch(category) {
		
		case "food": 
		return new FoodReimbursement();
		
		case "lodging": 
		return new LodgingReimbursement();
		
		case "travel": 
		return new TravelReimbursement();
		
		case "other":
		return new OtherReimbursement();
				
		default: System.out.println("Category not found (failure)");
		return null;
		}
		
	}
	
}
