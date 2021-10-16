package com.revature.bankapp.model;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.Util;
import com.revature.bankapp.dao.impl.AccountDaoImpl;

public class Account {
	
	private int accountId;
	private int accountNumber;
	private double balance;
	private String firstName;
	private String lastName;
	private int customerId;
	private char approved;
	boolean success = true;
	Scanner sc = new Scanner(System.in);
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);
	
	AccountDaoImpl accdao = new AccountDaoImpl();
	
	public Account(int accountNumber, double initialAmount) {
		super();
		this.accountNumber = accountNumber;
		this.balance = initialAmount;
	}
	
	

	public Account(int id, int accountNumber, double balance) {
		super();
		this.accountId = id;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}



	public Account() {

	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public char getApproved() {
		return approved;
	}

	public void setApproved(char approved) {
		this.approved = approved;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int id) {
		this.accountId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double initialAmount) {
		this.balance = initialAmount;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String printId() {
		return "Account Id: "+ accountId +" Account Number: " + accountNumber + ", Balance:" + balance;
	}
	
	public String print() {
		return "Account Number: " + accountNumber + ", Balance:" + balance;
	}

	@Override
	public String toString() {
		return "Account Number: " + accountNumber + ", Balance: " + balance + ", FirstName: " + firstName
				+ ", Last Name: " + lastName + ", Customer Id: " + customerId + ", Account Id: " + accountId;
	}



//	public double withdraw(double withdrawAmount) {
//		while (success) {
//			if (withdrawAmount < 0) {
//				LOGGER.info("Enter Amount greater than 0");
//			} else if (withdrawAmount <= initialAmount) {
//				initialAmount -= withdrawAmount;
//				success = false;
//				try {
//					accdao.insert(new Transactions('D', withdrawAmount));
//					accdao.update(this);
//					LOGGER.info(" Withdraw Successfull");
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			} else {
//				LOGGER.info("Insufficient funds");
//			}
//
//		}
//		return initialAmount;
//	}

//	public double deposit(double depositAmount) {
//		while (success) {
//			if (depositAmount < 0) {
//				LOGGER.info("Enter Amount greater than 0");
//			} else {
//				initialAmount += depositAmount;
//				success = false;
//				try {
//					accdao.insert(new Transactions('C', depositAmount));
//					accdao.update(this);
//					LOGGER.info("Successfull");
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//		return initialAmount;
//	}
//
//	
//	public void transfer(double amount) {
//		initialAmount += amount;
//		try {
//			accdao.insertTransfer(new Transactions('C', amount));
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			accdao.updateTransfer(this);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

}
