package com.revature.bankapp.model;

import java.sql.SQLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.Util;
import com.revature.bankapp.dao.impl.AccountDaoImpl;

public class Account {
	
	private int id;
	private String accountNumber;
	private double initialAmount;
	private String name;
	private int customerId;
	private char approved;
	boolean success = true;
	Scanner sc = new Scanner(System.in);
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);
	
	AccountDaoImpl accdao = new AccountDaoImpl();
	
	public Account(String accountNumber, double initialAmount) {
		super();
		this.accountNumber = accountNumber;
		this.initialAmount = initialAmount;
	}

	public Account() {

	}
	
	
	public char getApproved() {
		return approved;
	}

	public void setApproved(char approved) {
		this.approved = approved;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getInitialAmount() {
		return initialAmount;
	}

	public void setInitialAmount(double initialAmount) {
		this.initialAmount = initialAmount;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String printId() {
		return "Account Id: "+ id +" Account Number: " + accountNumber + ", Balance:" + initialAmount;
	}
	
	public String print() {
		return "Account Number: " + accountNumber + ", Balance:" + initialAmount;
	}

	@Override
	public String toString() {
		return "Customer Id: " + customerId + " Name: " + name + " Account Number: " + accountNumber + ", Balance:" + initialAmount;
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
