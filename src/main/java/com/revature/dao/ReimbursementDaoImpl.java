package com.revature.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.daoservice.EmployeeDaoService;
import com.revature.factory.Reimbursement;
import com.revature.factory.ReimbursementFactory;
import com.revature.logs.LogHere;
import com.revature.model.Employee;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

	private static ReimbursementDaoImpl instance;
	private ReimbursementDaoImpl() {}
	
	public static ReimbursementDaoImpl getInstance() {
		if(instance == null) {
			instance = new ReimbursementDaoImpl();
		}
		return instance;
	}
	
	@Override
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> reimbursementlist = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {				
				Reimbursement newreimbursement = ReimbursementFactory.getReimbursement(rs.getString("category"));
				
				newreimbursement.setId(rs.getInt("id"));
				newreimbursement.setAmount(rs.getDouble("amount"));
				newreimbursement.setRequestor_id(rs.getInt("requestor_id"));
				newreimbursement.setApprover_id(rs.getInt("approver_id"));
				newreimbursement.setStatus(rs.getString("status"));
				newreimbursement.setTimemade(rs.getTimestamp("timemade"));
				newreimbursement.setTimeapproved(rs.getTimestamp("timeapproved"));
				newreimbursement.setReason(rs.getString("reason"));
				
				Blob new_image = rs.getBlob("image");
//				System.out.println(new_image);
				InputStream image = new_image.getBinaryStream();
				newreimbursement.setImage(image);
				
				reimbursementlist.add(newreimbursement);			
			}
			return reimbursementlist;	
		}  catch (SQLException sqle) {
			LogHere.warn(sqle.getMessage());
			LogHere.warn("SQLE State: " + sqle.getSQLState());
			LogHere.warn("Error code: " + sqle.getErrorCode());
		} 
		return null;
	}
	

	@Override
	public List<Reimbursement> getPendingReimbursements() {
		List<Reimbursement> reimbursementlist = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement WHERE status='pending'");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {				
				Reimbursement newreimbursement = ReimbursementFactory.getReimbursement(rs.getString("category"));
				
				newreimbursement.setId(rs.getInt("id"));
				newreimbursement.setAmount(rs.getDouble("amount"));
				newreimbursement.setRequestor_id(rs.getInt("requestor_id"));
				newreimbursement.setApprover_id(rs.getInt("approver_id"));
				newreimbursement.setStatus(rs.getString("status"));
				newreimbursement.setTimemade(rs.getTimestamp("timemade"));
				newreimbursement.setTimeapproved(rs.getTimestamp("timeapproved"));
				newreimbursement.setReason(rs.getString("reason"));
				
				Blob new_image = rs.getBlob("image");
				InputStream image = new_image.getBinaryStream();
				newreimbursement.setImage(image);				
				reimbursementlist.add(newreimbursement);
			}
			return reimbursementlist;	
		}  catch (SQLException sqle) {
			LogHere.warn(sqle.getMessage());
			LogHere.warn("SQLE State: " + sqle.getSQLState());
			LogHere.warn("Error code: " + sqle.getErrorCode());
		} 
		return null;
	}

	@Override
	public List<Reimbursement> getApprovedReimbursements() {
		List<Reimbursement> reimbursementlist = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement WHERE status='approved'");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {				
				Reimbursement newreimbursement = ReimbursementFactory.getReimbursement(rs.getString("category"));
				
				newreimbursement.setId(rs.getInt("id"));
				newreimbursement.setAmount(rs.getDouble("amount"));
				newreimbursement.setRequestor_id(rs.getInt("requestor_id"));
				newreimbursement.setApprover_id(rs.getInt("approver_id"));
				newreimbursement.setStatus(rs.getString("status"));
				newreimbursement.setTimemade(rs.getTimestamp("timemade"));
				newreimbursement.setTimeapproved(rs.getTimestamp("timeapproved"));
				newreimbursement.setReason(rs.getString("reason"));
				
				Blob new_image = rs.getBlob("image");
				InputStream image = new_image.getBinaryStream();
				newreimbursement.setImage(image);				
				reimbursementlist.add(newreimbursement);
			}
			return reimbursementlist;	
		}  catch (SQLException sqle) {
			LogHere.warn(sqle.getMessage());
			LogHere.warn("SQLE State: " + sqle.getSQLState());
			LogHere.warn("Error code: " + sqle.getErrorCode());
		} 
		return null;
	}

	@Override
	public List<Reimbursement> getRejectedReimbursements() {
		List<Reimbursement> reimbursementlist = new ArrayList<>();
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement WHERE status='rejected'");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {				
				Reimbursement newreimbursement = ReimbursementFactory.getReimbursement(rs.getString("category"));
				
				newreimbursement.setId(rs.getInt("id"));
				newreimbursement.setAmount(rs.getDouble("amount"));
				newreimbursement.setRequestor_id(rs.getInt("requestor_id"));
				newreimbursement.setApprover_id(rs.getInt("approver_id"));
				newreimbursement.setStatus(rs.getString("status"));
				newreimbursement.setTimemade(rs.getTimestamp("timemade"));
				newreimbursement.setTimeapproved(rs.getTimestamp("timeapproved"));
				newreimbursement.setReason(rs.getString("reason"));
				
				Blob new_image = rs.getBlob("image");
				InputStream image = new_image.getBinaryStream();
				newreimbursement.setImage(image);				
				reimbursementlist.add(newreimbursement);
			}
			return reimbursementlist;	
		}  catch (SQLException sqle) {
			LogHere.warn(sqle.getMessage());
			LogHere.warn("SQLE State: " + sqle.getSQLState());
			LogHere.warn("Error code: " + sqle.getErrorCode());
		} 
		return null;
	}

	@Override
	public Reimbursement getReimbursementFromEmployee(String employeename) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement "
					+ "INNER JOIN employee ON employee.id = reimbursement.requestor_id "
					+ "WHERE employee.id = ?");
			Employee new_employee = EmployeeDaoService.getEmployee(employeename);
			stmt.setInt(1, new_employee.getId());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {				
				Reimbursement newreimbursement = ReimbursementFactory.getReimbursement(rs.getString("category"));
				
				newreimbursement.setId(rs.getInt("id"));
				newreimbursement.setAmount(rs.getDouble("amount"));
				newreimbursement.setRequestor_id(rs.getInt("requestor_id"));
				newreimbursement.setApprover_id(rs.getInt("approver_id"));
				newreimbursement.setStatus(rs.getString("status"));
				newreimbursement.setTimemade(rs.getTimestamp("timemade"));
				newreimbursement.setTimeapproved(rs.getTimestamp("timeapproved"));
				newreimbursement.setReason(rs.getString("reason"));
				
				Blob new_image = rs.getBlob("image");
				InputStream image = new_image.getBinaryStream();
				newreimbursement.setImage(image);				
				return newreimbursement;	
			}
		}  catch (SQLException sqle) {
			LogHere.warn(sqle.getMessage());
			LogHere.warn("SQLE State: " + sqle.getSQLState());
			LogHere.warn("Error code: " + sqle.getErrorCode());
		} 
		return null;
	}
	
	@Override
	public Reimbursement getReimbursementFromId(int id) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM reimbursement "
					+ "WHERE id = ?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {				
				Reimbursement newreimbursement = ReimbursementFactory.getReimbursement(rs.getString("category"));
				
				newreimbursement.setId(rs.getInt("id"));
				newreimbursement.setAmount(rs.getDouble("amount"));
				newreimbursement.setRequestor_id(rs.getInt("requestor_id"));
				newreimbursement.setApprover_id(rs.getInt("approver_id"));
				newreimbursement.setStatus(rs.getString("status"));
				newreimbursement.setTimemade(rs.getTimestamp("timemade"));
				newreimbursement.setTimeapproved(rs.getTimestamp("timeapproved"));
				newreimbursement.setReason(rs.getString("reason"));
				
				Blob new_image = rs.getBlob("image");
				InputStream image = new_image.getBinaryStream();
				newreimbursement.setImage(image);
				
				return newreimbursement;	
			}
		}  catch (SQLException sqle) {
			LogHere.warn(sqle.getMessage());
			LogHere.warn("SQLE State: " + sqle.getSQLState());
			LogHere.warn("Error code: " + sqle.getErrorCode());
		} 
		return null;
	}

	@Override
	public boolean insertReimbursement(Reimbursement reimbursement) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL insert_reimbursement(?,?,?,?)}");
			stmt.setInt(++index, reimbursement.getRequestor_id());
			stmt.setDouble(++index, reimbursement.getAmount());
			stmt.setString(++index, reimbursement.getCategory());
			stmt.setBlob(++index, reimbursement.getImage());
			return stmt.executeUpdate() > 0;
		}  catch (SQLException sqle) {
			LogHere.warn(sqle.getMessage());
			LogHere.warn("SQLE State: " + sqle.getSQLState());
			LogHere.warn("Error code: " + sqle.getErrorCode());
		} 
		return false;
	}

	@Override
	public boolean updateReimbursement(Reimbursement reimbursement) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL update_reimbursement(?,?,?)}");
			stmt.setInt(++index, reimbursement.getId());
			stmt.setInt(++index, reimbursement.getApprover_id());
			stmt.setString(++index, reimbursement.getStatus());
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		}  catch (SQLException sqle) {
			LogHere.warn(sqle.getMessage());
			LogHere.warn("SQLE State: " + sqle.getSQLState());
			LogHere.warn("Error code: " + sqle.getErrorCode());
		} 
		return false;
	}

	@Override
	public boolean rejectReimbursement(Reimbursement reimbursement) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL reject_reimbursement(?,?,?)}");
			stmt.setInt(++index, reimbursement.getId());
			stmt.setString(++index, reimbursement.getReason());
			stmt.setInt(++index, reimbursement.getApprover_id());
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		}  catch (SQLException sqle) {
			LogHere.warn(sqle.getMessage());
			LogHere.warn("SQLE State: " + sqle.getSQLState());
			LogHere.warn("Error code: " + sqle.getErrorCode());
		} 
		return false;
	}

	@Override
	public boolean approveReimbursement(Reimbursement reimbursement) {
		int index = 0;
		try(Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL approve_reimbursement(?,?, ?)}");
			stmt.setInt(++index, reimbursement.getId());
			stmt.setString(++index, reimbursement.getReason());
			stmt.setInt(++index, reimbursement.getApprover_id());
			int rowsAffected = stmt.executeUpdate();
			return rowsAffected > 0;
		}  catch (SQLException sqle) {
			LogHere.warn(sqle.getMessage());
			LogHere.warn("SQLE State: " + sqle.getSQLState());
			LogHere.warn("Error code: " + sqle.getErrorCode());
		} 
		return false;
	}
	
	
	@Override
	public byte[] getImageBytes(int id) {
		try (Connection conn = ConnectionUtil.getConnection()) {
	    	byte[] image = null;
			PreparedStatement stmt = conn.prepareStatement("SELECT image FROM reimbursement " + 
					"WHERE id = " +  id);			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {	
				Blob blob = rs.getBlob("image");
				int blobLength = (int) blob.length();  
				image = blob.getBytes(1, blobLength);
				blob.free();
			}
			return image;
		} catch(SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL STATE " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;		
	}




}
