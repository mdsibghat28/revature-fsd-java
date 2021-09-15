package com.revature.bankapp.model;

import java.util.List;

import com.revature.bankapp.accounts.Account;

public class Customer {

	private long customerId;
	private String name;
	private String userId;
	private String password;
	public static  List<Account> accountList;

	private static long counter = 0;

	public Customer(String name, String userId, String password) {
		super();
		counter++;

		this.customerId = counter;
		this.name = name;
		this.userId = userId;
		this.password = password;
	}

	public static List<Account> getAccountList() {
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

	public void addAccount(Account account) {
		accountList.add(account);
	}

	@Override
	public String toString() {
		return "Customer [Name=" + name + ", User Id=" + userId + ", Password=" + password + ", Customer Id="
				+ customerId + "]";
	}

}
