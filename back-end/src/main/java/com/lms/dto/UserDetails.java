package com.lms.dto;

import java.sql.Timestamp;

public class UserDetails {
	
//Declared variable for UserDetails class.

String firstname;
String lastname;
String email;
String gender;
Timestamp date_of_birth;
String registration_number;
Timestamp membership_Starting_date;
Timestamp membership_Ending_date;
long contact_number;
String address;
boolean isActive;
String password;
int dateDiff;

public int getDateDiff() {
	return dateDiff;
}

public void setDateDiff(int dateDiff) {
	this.dateDiff = dateDiff;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

//Getter setter methods for above declared variable.


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

public String getRegistration_number() {
	return registration_number;
}
public void setRegistration_number(String registration_number) {
	this.registration_number = registration_number;
}

public Timestamp getMembership_Starting_date() {
	return membership_Starting_date;
}
public void setMembership_Starting_date(Timestamp membership_Starting_date) {
	this.membership_Starting_date = membership_Starting_date;
}

public Timestamp getMembership_Ending_date() {
	return membership_Ending_date;
}
public void setMembership_Ending_date(Timestamp membership_Ending_date) {
	this.membership_Ending_date = membership_Ending_date;
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

public boolean isActive() {
	return isActive;
}
public void setActive(boolean isActive) {
	this.isActive = isActive;
}

@Override
public String toString() {
	return "UserDetails [firstname=" + firstname + ", lastname=" + lastname + ", email="
			+ email + ", gender=" + gender + ", date_of_birth=" + date_of_birth + ", registration_number="
			+ registration_number + ", membership_Starting_date=" + membership_Starting_date
			+ ", membership_Ending_date=" + membership_Ending_date + ", contact_number=" + contact_number + ", address="
			+ address + ", isActive=" + isActive + "]";
}

}
