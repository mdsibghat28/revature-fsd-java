package com.revature.bankapp.model;

import java.util.List;

import com.revature.bankapp.accounts.Account;

public class Customer {

	private static long id;
	private String name;
	private String userId;
	private String password;
	private static  List<Account> accountList;

	private long counter = 0;

	public Customer(String name, String userId, String password, List<Account> accountList) {
		super();
		counter++;

		this.id = counter;
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.accountList = accountList;
	}

	public  List<Account> getAccountList() {
		return accountList;
	}

	public static long getId() {
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
	
	public static void addAccount(Account account) {
		accountList.add(account);
	}
	
	

}
