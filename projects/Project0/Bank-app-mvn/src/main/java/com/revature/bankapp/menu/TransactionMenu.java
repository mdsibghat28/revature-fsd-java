package com.revature.bankapp.menu;

import java.sql.SQLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.accounts.DisplayAccAndTrans;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.dao.impl.AccountDaoImpl;

public class TransactionMenu extends Menu{
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);
	
	public static String accNumber;
	public static String transferAccNum;
	Scanner sc = new Scanner(System.in);
	CustomerMenu cm = new CustomerMenu("Customer Menu");
	
	public TransactionMenu(String name) {
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
		LOGGER.info("Account Number: " + accNumber + " selected");
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
			DisplayAccAndTrans.transactionsList();
			cm.displayMenuLoop();
			break;
			
		case 4:
			try {
				double balance = accdao.currentAccount().getInitialAmount();
				LOGGER.info("Balance: " + balance);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			cm.displayMenuLoop();
			break;
		
		case 5:
			LOGGER.info("Enter Beneficiary Account Number: ");
			transferAccNum = sc.nextLine();
			System.out.println("Enter amount to transfer: ");
			double amount = sc.nextDouble();
			try {
				LOGGER.info("Initiating Transfer......");
				accdao.currentAccount().withdraw(amount);
			} catch (SQLException e) {
				e.printStackTrace();
				LOGGER.info("Transfer Failed (Amount not Debited)");
			}
			try {
				accdao.transferAccount().transfer(amount);
			} catch (SQLException e) {
				e.printStackTrace();
				LOGGER.info("Transfer Failed (Amount Debited)");
			}
			cm.displayMenuLoop();
			break;
			
		case 6:
			cm.displayMenuLoop();
			break;
			
		case 7:
			MainMenu mm = new MainMenu("Main Menu");
			mm.displayMenuLoop();
			break;          
		}
		
	}

}
