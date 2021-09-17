package com.revature.bankapp.accounts;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.bankapp.dao.impl.AccountDaoImpl;

public class Account {

	private String accountNumber;
	private double initialAmount;
	private ArrayList<Transactions> transactions;
	AccountDaoImpl accdao = new AccountDaoImpl();
	public static String transferAccNum;
	boolean success = true;

	public Account(String accountNumber, double initialAmount, ArrayList<Transactions> transactions) {
		super();
		this.accountNumber = accountNumber;
		this.initialAmount = initialAmount;
		this.transactions = transactions;
	}

	public Account(String accountNumber, double initialAmount) {
		super();
		this.accountNumber = accountNumber;
		this.initialAmount = initialAmount;
	}

	public Account() {

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

	public ArrayList<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transactions> transactions) {
		this.transactions = transactions;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Account Number: " + accountNumber + ", Balance:" + initialAmount;
	}

	public double withdraw() {
		Scanner sc = new Scanner(System.in);
		while (success) {
			System.out.println("Enter amount: ");
			double withdrawAmount = sc.nextDouble();
			if (withdrawAmount < 0) {
				System.out.println("Enter Amount greater than 0");
			} else if (withdrawAmount <= initialAmount) {
				initialAmount -= withdrawAmount;
				success = false;
				try {
					accdao.insert(new Transactions('W', withdrawAmount));
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

	public double deposit() {
		Scanner sc = new Scanner(System.in);
		while (success) {
			System.out.println("Enter Amount to deposit:");
			double depositAmount = sc.nextDouble();
			if (depositAmount < 0) {
				System.out.println("Enter Amount greater than 0");
			} else {
				initialAmount += depositAmount;
				success = false;
				try {
					accdao.insert(new Transactions('D', depositAmount));
					accdao.update(this);
					System.out.println("Successfull");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return initialAmount;
	}

	public void transfer() {
		Scanner sc = new Scanner(System.in);
		while (success) {
			System.out.println("Enter Account number of customer: ");
			transferAccNum = sc.nextLine();
			System.out.println("Enter amount to transfer: ");
			double transferAmount = sc.nextDouble();
			if (transferAmount < 0) {
				System.out.println("Enter Amount greater than 0");
			} else if (transferAmount <= initialAmount) {
				initialAmount -= transferAmount;
				success = false;
				try {
					accdao.insert(new Transactions('W', transferAmount));
					accdao.update(this);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				initialAmount += transferAmount;
				try {
					accdao.insert(new Transactions('D', transferAmount));
					accdao.updateTransfer(accdao.transferAccount());
					System.out.println("Successfull");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Insufficient funds");
			}

		}

	}
//
//	public void printStatement() {
//		System.out.println("Account Statement of " + accountNumber);
//		System.out.println("Initial Balance: " + balance);
//		
//		System.out.println("\n---------------------------");
//		System.out.println("Type  Transaction   Balance");
//		System.out.println("---------------------------");
//		
//		for (Transactions transaction : transactions ) {
//			
//			if (transaction.getType() == 'W') {
//				balance -= transaction.getAmount();
//			} else if (transaction.getType() == 'D'){
//				balance += transaction.getAmount();
//			}
//			
//			transaction.displayTransaction(balance);
//		}
//		
//		System.out.println("---------------------------");
//	}
//	

}
