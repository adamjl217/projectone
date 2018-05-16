package com.revature.dao;

import java.util.List;

import com.revature.factory.Reimbursement;

public interface ReimbursementDao {

	List<Reimbursement> getAllReimbursements();
	List<Reimbursement> getPendingReimbursements();
	List<Reimbursement> getApprovedReimbursements();
	List<Reimbursement> getRejectedReimbursements();

	Reimbursement getReimbursementFromEmployee(String employeename);
	boolean updateReimbursement(Reimbursement reimbursement);
	boolean insertReimbursement(Reimbursement reimbursement);
	boolean rejectReimbursement(Reimbursement reimbursement);
	boolean approveReimbursement(Reimbursement reimbursement);
	Reimbursement getReimbursementFromId(int id);

}
