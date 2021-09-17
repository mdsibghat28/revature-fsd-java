package com.revature.bankapp.accounts;

public class Account {

	private String accountNumber;
	private double initialAmount;
//	private Transactions[] transactions;

//	public Account(String accountNumber, double balance, Transactions[] transactions) {
//		this.accountNumber = accountNumber;
//		this.balance = balance;
//		this.transactions = transactions;
//	}

	public Account(String accountNumber, double initialAmount) {
		super();
		this.accountNumber = accountNumber;
		this.initialAmount = initialAmount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return initialAmount;
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
