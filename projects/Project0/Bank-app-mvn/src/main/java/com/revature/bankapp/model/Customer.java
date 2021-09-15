package com.revature.bankapp.model;

import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.accounts.Account;

public class Customer {

	private long customerId;
	private String name;
	private String userId;
	private String password;
	private ArrayList<Account> accountList;

	private static long counter = 0;

	public Customer(String name, String userId, String password, ArrayList<Account> accountList) {
		super();
		counter++;
		this.customerId = counter;
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.accountList = accountList;
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

	public static void addAccount(Account account) {
		DataManager.currentCustomer().getAccountList().add(account);
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", userId=" + userId + ", password=" + password
				+ ", accountList = " + accountList + "]";
	}

}
