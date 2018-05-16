package com.revature.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Employee implements Serializable{

	private static final long serialVersionUID = -7532638298861401827L;
	
	private int id;
	private String username;
	private String password;
	private boolean managerstatus;
	private String firstname;
	private String lastname;
	private LocalDate datehired;
	private String email;
	private long phonenumber;
	
	
	
	public Employee() {
		super();
	}
	
	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Employee(String username, String password, boolean managerstatus, String firstname, String lastname,
			String email, long phonenumber) {
		super();
		this.username = username;
		this.password = password;
		this.managerstatus = managerstatus;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phonenumber = phonenumber;
	}

	public Employee(int id, String username, String password, boolean managerstatus, String firstname, String lastname,
			LocalDate datehired, String email, long phonenumber) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.managerstatus = managerstatus;
		this.firstname = firstname;
		this.lastname = lastname;
		this.datehired = datehired;
		this.email = email;
		this.phonenumber = phonenumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isManagerstatus() {
		return managerstatus;
	}

	public void setManagerstatus(boolean managerstatus) {
		this.managerstatus = managerstatus;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getDatehired() {
		return datehired;
	}

	public void setDatehired(LocalDate datehired) {
		this.datehired = datehired;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datehired == null) ? 0 : datehired.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + (managerstatus ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (int) (phonenumber ^ (phonenumber >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Employee other = (Employee) obj;
		if (datehired == null) {
			if (other.datehired != null)
				return false;
		} else if (!datehired.equals(other.datehired))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (id != other.id)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (managerstatus != other.managerstatus)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phonenumber != other.phonenumber)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", managerstatus="
				+ managerstatus + ", firstname=" + firstname + ", lastname=" + lastname + ", datehired=" + datehired
				+ ", email=" + email + ", phonenumber=" + phonenumber + "]";
	}

	
	
}
