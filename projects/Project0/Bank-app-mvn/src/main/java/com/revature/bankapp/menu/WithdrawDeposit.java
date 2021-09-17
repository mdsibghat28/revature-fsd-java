package com.revature.bankapp.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.accounts.ViewAccounts;
import com.revature.bankapp.dao.impl.AccountDaoImpl;

public class WithdrawDeposit extends Menu{
	
	public static String accNumber;
	public static String transferAccNum;
	Scanner sc = new Scanner(System.in);
	CustomerMenu cm = new CustomerMenu("Customer Menu");
	
	public WithdrawDeposit(String name) {
		super(name);
		addMenuItems("Withdraw");
		addMenuItems("Deposit");
		addMenuItems("View Transactions");
		addMenuItems("View Balance");
		addMenuItems("Transfer to account");
		addMenuItems("Return to Customer Menu");
		addMenuItems("LogOut");
	}
	
	public String getAccount() {
		System.out.println("Enter Account number to make transaction: ");
		accNumber = sc.nextLine();
		System.out.println("Account Number: " + accNumber);
		return accNumber;
	}


	@Override
	void handleSelection() {
		AccountDaoImpl accdao = new AccountDaoImpl();
		switch (selection) {

		case 1:
			try {
				System.out.println("Enter amount to withdraw: ");
				double amount = sc.nextDouble();
				accdao.currentAccount().withdraw(amount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			cm.displayMenuLoop();
			break;

		case 2:
			
			try {
				System.out.println("Enter amount to deposit: ");
				double amount = sc.nextDouble();
				accdao.currentAccount().deposit(amount);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			cm.displayMenuLoop();
			break;
			
		case 3:
			try {
				accdao.currentAccount();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ViewAccounts.transactionsList();
			cm.displayMenuLoop();
			break;
			
		case 4:
			try {
				double balance = accdao.currentAccount().getInitialAmount();
				System.out.println("Balance: " + balance);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			cm.displayMenuLoop();
			break;
		
		case 5:
			System.out.println("Enter Account Number of receiver: ");
			transferAccNum = sc.nextLine();
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
			cm.displayMenuLoop();
			break;
			
		case 6:
			cm.displayMenuLoop();
			
		case 7:
			MainMenu mm = new MainMenu("Main Menu");
			mm.displayMenuLoop();
		}
		
	}

}
