package com.revature.bankapp.model;

import java.sql.SQLException;

import com.revature.bankapp.dao.impl.AccountDaoImpl;

public class Account {

	private String accountNumber;
	private String name;
	private String branch;
	private long balance;
	private boolean success = true;
	AccountDaoImpl accdao = new AccountDaoImpl();

	public Account() {
		super();
	}

	public Account(String accountNumber, String name, String branch, long balance) {
		super();

		this.accountNumber = accountNumber;
		this.name = name;
		this.branch = branch;
		this.balance = balance;
	}
  
	public Account(String accountNumber, long balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", name=" + name + ", branch=" + branch + ", balance="
				+ balance + "]";
	}

	public double withdraw(double withdrawAmount) {
		while (success) {
			if (withdrawAmount < 0) {
				System.out.println("Enter Amount greater than 0");
			} else if (withdrawAmount <= balance) {
				balance -= withdrawAmount;
				success = false;
				try {
					accdao.insert(new Transaction('D', withdrawAmount));
					accdao.update(this);
					System.out.println("Successfull");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Insufficient funds");
			}

		}
		return balance;
	}

	public double deposit(double depositAmount) {
		while (success) {
			if (depositAmount < 0) {
				System.out.println("Enter Amount greater than 0");
			} else {
				balance += depositAmount;
				success = false;
				try {
					accdao.insert(new Transaction('C', depositAmount));
					accdao.update(this);
					System.out.println("Successfull");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return balance;
	}

	public void transfer(double amount) {
		balance += amount;
		try {
			accdao.insertTransfer(new Transaction('C', amount));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			accdao.updateTransfer(this);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
