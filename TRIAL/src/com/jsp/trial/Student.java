package com.jsp.trial;

public class Student {
	private String firstName;
	private String lastname;
	private boolean goldCustomer;
	public Student(String firstName, String lastname, boolean goldCustomer) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
		this.goldCustomer = goldCustomer;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public boolean isGoldCustomer() {
		return goldCustomer;
	}
	public void setGoldCustomer(boolean goldCustomer) {
		this.goldCustomer = goldCustomer;
	}
	
	
}
