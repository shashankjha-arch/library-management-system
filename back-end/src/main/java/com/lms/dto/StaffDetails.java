package com.lms.dto;

import java.sql.Timestamp;

public class StaffDetails {
	
//Declared variable for StaffDetails class.
	String firstname;
	String lastname;
	String email;
	String gender;
	Timestamp date_of_birth;
	Timestamp job_Starting_date;
	long contact_number;
	String address;
	String employeeId;
	boolean isActive;
	String password;
	
	
	//Getter setter methods for above declared variable. 
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Timestamp getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Timestamp date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	public Timestamp getJob_Starting_date() {
		return job_Starting_date;
	}
	public void setJob_Starting_date(Timestamp job_Starting_date) {
		this.job_Starting_date = job_Starting_date;
	}
	
	public long getContact_number() {
		return contact_number;
	}
	public void setContact_number(long contact_number) {
		this.contact_number = contact_number;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@Override
	public String toString() {
		return "StaffDetails [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", gender="
				+ gender + ", date_of_birth=" + date_of_birth + ", job_Starting_date=" + job_Starting_date
				+ ", contact_number=" + contact_number + ", address=" + address + ", employeeId=" + employeeId
				+ ", isActive=" + isActive + "]";
	}
}
