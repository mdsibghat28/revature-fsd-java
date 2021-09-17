package com.revature.bankapp.accounts;

public class Transactions {

	private char type;
	private double amount;

	public Transactions(char type, double amount) {
		this.type = type;
		this.amount = amount;
	}
	
	public Transactions() {
		
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Type: " + type + ", Amount: " + amount ;
	}
	
	
	
//	public static double transaction(char type, double amount) {
//		double balance = Account.getInitialAmount();
//		if ( type == 'W') {
//			balance += amount;
//		} else if (type == 'D'){
//			balance  -= amount;
//		}
//		return balance;
//	}


}
