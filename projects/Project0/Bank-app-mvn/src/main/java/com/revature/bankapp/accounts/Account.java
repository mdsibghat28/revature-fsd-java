package com.revature.bankapp.accounts;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.impl.AccountDaoImpl;

public class Account {

	private String accountNumber;
	private double initialAmount;
	private String name;
	private int customerId;
	AccountDaoImpl accdao = new AccountDaoImpl();
	boolean success = true;

	Scanner sc = new Scanner(System.in);
	
	public Account(String accountNumber, double initialAmount) {
		super();
		this.accountNumber = accountNumber;
		this.initialAmount = initialAmount;
	}

	public Account() {

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
	
	public String print() {
		return "Account Number: " + accountNumber + ", Balance:" + initialAmount;
	}

	@Override
	public String toString() {
		return "Customer Id: " + customerId + " Name: " + name + " Account Number: " + accountNumber + ", Balance:" + initialAmount;
	}

	public double withdraw(double withdrawAmount) {
		while (success) {
//			System.out.println("Enter amount: ");
//			double withdrawAmount = sc.nextDouble();
			if (withdrawAmount < 0) {
				System.out.println("Enter Amount greater than 0");
			} else if (withdrawAmount <= initialAmount) {
				initialAmount -= withdrawAmount;
				success = false;
				try {
					accdao.insert(new Transactions('D', withdrawAmount));
					accdao.update(this);
					System.out.println("Successfull");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Insufficient funds");
			}

		}
		return initialAmount;
	}

	public double deposit(double depositAmount) {
		while (success) {
			if (depositAmount < 0) {
				System.out.println("Enter Amount greater than 0");
			} else {
				initialAmount += depositAmount;
				success = false;
				try {
					accdao.insert(new Transactions('C', depositAmount));
					accdao.update(this);
					System.out.println("Successfull");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return initialAmount;
	}

	
	public void transfer(double amount) {
		initialAmount += amount;
		try {
			accdao.insertTransfer(new Transactions('C', amount));
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
