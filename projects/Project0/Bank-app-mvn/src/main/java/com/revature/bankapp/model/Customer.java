package com.revature.bankapp.model;

import java.util.ArrayList;

import com.revature.bankapp.accounts.Account;

public class Customer {

	private int customerId;
	private String name;
	private String userId;
	private String password;
	private ArrayList<Account> accountList;


	public Customer(String name, String userId, String password, ArrayList<Account> accountList) {
		super();
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.accountList = accountList;
	}
	
	

	public Customer(String name, String userId, String password) {
		super();
		this.name = name;
		this.userId = userId;
		this.password = password;
	}
	
	public Customer() {
		
	}



	public ArrayList<Account> getAccountList() {
		return accountList;
	}


	public long getId() {
		return customerId;
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
	
	

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}

	public static void addAccount(Account account) {
		DataManager.currentCustomer().getAccountList().add(account);
	}

	@Override
	public String toString() {
		return "CustomerId: " + customerId + "  Name: " + name + "  UserId=" + userId;
	}

}
