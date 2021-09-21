package com.revature.bankapp.menu;

import java.sql.SQLException;
import java.util.Scanner;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.ViewAccountsAndTransaction;

public class TransactionMenu extends Menu {
	public static String accNumber;
	Scanner sc = new Scanner(System.in);

	public static String transferaccnumber;
	CustomerMenu cm = new CustomerMenu("Customer Menu");

	public TransactionMenu(String name) {
		super(name);
		addMenuItem("Withdrwal");
		addMenuItem("Deposit");
		addMenuItem("View Balance");
		addMenuItem("View Transaction Log");
		addMenuItem("Transfer to another Account");
		addMenuItem("Back");
	}

	public String getAccount() {
		System.out.println("Enter Account number to make transaction: ");
		accNumber = sc.nextLine();
		System.out.println("Account Number: " + accNumber);
		return accNumber;
	}

	@Override
	void handleAction() {
		AccountDaoImpl accdao = new AccountDaoImpl();
		switch (selection) {
		case 1:
			try {
				System.out.println("Enter amount to withdraw: ");
				long amount = sc.nextLong();
				accdao.currentAccount().withdraw(amount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			cm.displayMenuAndCaptureSelection();
			break;

		case 2:

			try {
				System.out.println("Enter amount to deposit: ");
				double amount = sc.nextDouble();
				accdao.currentAccount().deposit(amount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			cm.displayMenuAndCaptureSelection();
			break;

		case 4:
			try {
				accdao.currentAccount();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ViewAccountsAndTransaction.transactionsList();
			cm.displayMenuAndCaptureSelection();
			break;

		case 3:
			try {
				double balance = accdao.currentAccount().getBalance();
				System.out.println("Balance: " + balance);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			cm.displayMenuAndCaptureSelection();
			break;

		case 5:
			System.out.println("Enter Account Number of receiver: ");
			transferaccnumber = sc.nextLine();
			System.out.println("Enter amount to transfer: ");
			double amount = sc.nextDouble();
			try {
				accdao.currentAccount().withdraw(amount);
				System.out.println("Initiated");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("withdraw failed");
			}
			try {
				accdao.transferAccount().transfer(amount);
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("deposit failed");
			}
			cm.displayMenuAndCaptureSelection();
			break;

		case 6:
			cm.displayMenuAndCaptureSelection();

		case 7:
			MainMenu mm = new MainMenu("Main Menu");
			mm.displayMenuAndCaptureSelection();
		}

	}

}
