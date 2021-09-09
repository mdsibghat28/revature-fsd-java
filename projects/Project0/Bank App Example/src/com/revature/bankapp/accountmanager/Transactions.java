package com.revature.bankapp.accountmanager;

public class Transactions {

	private char type;
	private double amount;

	public Transactions(char type, double amount) {
		this.type = type;
		this.amount = amount;
	}

	public void displayTransaction(double balance) {
		System.out.printf("%4c %12.2f %9.2f\n", type, amount, balance);
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

}
