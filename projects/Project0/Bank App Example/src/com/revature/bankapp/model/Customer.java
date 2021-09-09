package com.revature.bankapp.model;

import java.util.List;

import com.revature.bankapp.accountmanager.Account;

public class Customer {

	private long id;
	private String name;
	private String userId;
	private String password;
	private List<Account> accountList;

	private static long counter = 0;

	public Customer(String name, String userId, String password) {
		super();
		counter++;

		this.id = counter;
		this.name = name;
		this.userId = userId;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}
	

}
