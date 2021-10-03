package com.revature.bankapp.model;

public class Customer {

	private int customerId;
	private String firstName;
	private String LastName;
	private String email;
	private String password;


	
	public Customer() {
		
	}
	
	public Customer(int customerId, String firstName, String lastName, String email, String password) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		LastName = lastName;
		this.email = email;
		this.password = password;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}
	
	

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public Customer(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.email = email;
		this.password = password;
	}


}
