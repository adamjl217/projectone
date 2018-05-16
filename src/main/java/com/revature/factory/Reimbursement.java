package com.revature.factory;

import java.io.InputStream;
import java.sql.Timestamp;

public interface Reimbursement{

	public int getId();
	
	public void setId(int id);
	
	public double getAmount();
	
	public void setAmount(double amount);
	
	public String getCategory();
	public void setCategory(String category);
	public int getRequestor_id();
	public void setRequestor_id(int requestor_id);
	public int getApprover_id();
	public void setApprover_id(int approver_id);
	public String getStatus();
	public void setStatus(String status);
	public Timestamp getTimemade();
	public void setTimemade(Timestamp timemade);
	public Timestamp getTimeapproved();
	public void setTimeapproved(Timestamp timeapproved);
	public String getReason();
	public void setReason(String reason);
	public InputStream getImage();
	public void setImage(InputStream new_image);

}
