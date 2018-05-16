package com.revature.daoservice;

import java.util.List;

import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.factory.Reimbursement;

public class ReimbursementDaoService {

	private static ReimbursementDao dao = ReimbursementDaoImpl.getInstance();

	private ReimbursementDaoService() {}
	
	public static List<Reimbursement> getAllReimbursements(){
		return dao.getAllReimbursements();
	}
	
	public static List<Reimbursement> getPendingReimbursements(){
		return dao.getPendingReimbursements();
	}
	
	public static List<Reimbursement> getApprovedReimbursements(){
		return dao.getApprovedReimbursements();
	}
	
	public static List<Reimbursement> getRejectedReimbursements(){
		return dao.getRejectedReimbursements();
	}
	
	public static Reimbursement getReimbursementFromEmployee(String employeename) {
		return dao.getReimbursementFromEmployee(employeename);
	}
	
	public static boolean insertReimbursement(Reimbursement reimbursement) {
		return dao.insertReimbursement(reimbursement);
	}
	
	public static boolean updateReimbursement(Reimbursement reimbursement) {
		return dao.updateReimbursement(reimbursement);
	}
	
	public static boolean rejectReimbursement(Reimbursement reimbursement) {
		return dao.rejectReimbursement(reimbursement);
	}
	
	public static boolean approveReimbursement(Reimbursement reimbursement) {
		return dao.approveReimbursement(reimbursement);
	}
	
	public static Reimbursement getReimbursementFromId(int id) {
		return dao.getReimbursementFromId(id);
	}
	
	public static byte[] getImageBytes(int id) {
		return dao.getImageBytes(id);
	}

}
