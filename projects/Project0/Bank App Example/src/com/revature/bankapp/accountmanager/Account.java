package com.revature.bankapp.accountmanager;

public class Account {
	
	private String accountNumber;
	private double balance;
	private Transactions[] transactions;
	
	public Account(String accountNumber, double balance, Transactions[] transactions) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.transactions = transactions;
	}
	
	public void printStatement() {
		System.out.println("Account Statement of " + accountNumber);
		System.out.println("Initial Balance: " + balance);
		
		System.out.println("\n---------------------------");
		System.out.println("Type  Transaction   Balance");
		System.out.println("---------------------------");
		
		for (Transactions transaction : transactions ) {
			
			if (transaction.getType() == 'W') {
				balance -= transaction.getAmount();
			} else if (transaction.getType() == 'D'){
				balance += transaction.getAmount();
			}
			
			transaction.displayTransaction(balance);
		}
		
		System.out.println("---------------------------");
	}
	
}

