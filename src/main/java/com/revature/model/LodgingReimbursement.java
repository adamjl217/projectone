package com.revature.model;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Timestamp;

import com.revature.factory.Reimbursement;

public class LodgingReimbursement implements Reimbursement, Serializable{

	private static final long serialVersionUID = 186204664259058858L;
	private int id;
	private double amount;
	private String category = "lodging";
	private int requestor_id;
	private int approver_id;
	private String status;
	private Timestamp timemade;
	private Timestamp timeapproved;
	private String reason;
	private InputStream image;
	
//	private String streetaddress;
//	private String city;
//	private String state;
//	private String international;
//	private String locationcontact;
//	private Date startdate;
//	private Date enddate;
	
	
	public LodgingReimbursement() {}
	
	
	public LodgingReimbursement(int id, double amount, int requestor_id, String status,
			Timestamp timemade, String reason) {
		super();
		this.id = id;
		this.amount = amount;
		this.requestor_id = requestor_id;
		this.status = status;
		this.timemade = timemade;
		this.reason = reason;
	}
	
	public LodgingReimbursement(int id, double amount, int requestor_id, String status,
			Timestamp timemade, String reason, InputStream image) {
		super();
		this.id = id;
		this.amount = amount;
		this.requestor_id = requestor_id;
		this.status = status;
		this.timemade = timemade;
		this.reason = reason;
		this.image = image;
	}
	
	public LodgingReimbursement(int id, double amount, String category, int requestor_id, int approver_id,
			String status, Timestamp timemade, Timestamp timeapproved, String reason) {
		super();
		this.id = id;
		this.amount = amount;
		this.category = category;
		this.requestor_id = requestor_id;
		this.approver_id = approver_id;
		this.status = status;
		this.timemade = timemade;
		this.timeapproved = timeapproved;
		this.reason = reason;
	}
	
	public LodgingReimbursement(int id, double amount, String category, int requestor_id, int approver_id,
			String status, Timestamp timemade, Timestamp timeapproved, String reason, InputStream image) {
		super();
		this.id = id;
		this.amount = amount;
		this.category = category;
		this.requestor_id = requestor_id;
		this.approver_id = approver_id;
		this.status = status;
		this.timemade = timemade;
		this.timeapproved = timeapproved;
		this.reason = reason;
		this.image = image;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getRequestor_id() {
		return requestor_id;
	}


	public void setRequestor_id(int requestor_id) {
		this.requestor_id = requestor_id;
	}


	public int getApprover_id() {
		return approver_id;
	}


	public void setApprover_id(int approver_id) {
		this.approver_id = approver_id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Timestamp getTimemade() {
		return timemade;
	}


	public void setTimemade(Timestamp timemade) {
		this.timemade = timemade;
	}


	public Timestamp getTimeapproved() {
		return timeapproved;
	}


	public void setTimeapproved(Timestamp timeapproved) {
		this.timeapproved = timeapproved;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}

	public InputStream getImage() {
		return image;
	}


	public void setImage(InputStream image) {
		this.image = image;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + approver_id;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + id;
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + requestor_id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((timeapproved == null) ? 0 : timeapproved.hashCode());
		result = prime * result + ((timemade == null) ? 0 : timemade.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LodgingReimbursement other = (LodgingReimbursement) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (approver_id != other.approver_id)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id != other.id)
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (requestor_id != other.requestor_id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (timeapproved == null) {
			if (other.timeapproved != null)
				return false;
		} else if (!timeapproved.equals(other.timeapproved))
			return false;
		if (timemade == null) {
			if (other.timemade != null)
				return false;
		} else if (!timemade.equals(other.timemade))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "LodgingReimbursement [id=" + id + ", amount=" + amount + ", category=" + category + ", requestor_id="
				+ requestor_id + ", approver_id=" + approver_id + ", status=" + status + ", timemade=" + timemade
				+ ", timeapproved=" + timeapproved + ", reason=" + reason + "]";
	}
	
	

	
	
}
