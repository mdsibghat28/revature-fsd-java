package com.revature.bankapp.menu;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.accounts.Account;
import com.revature.bankapp.accounts.ViewAccounts;
import com.revature.bankapp.dao.impl.AccountDaoImpl;

public class WithdrawDeposit extends Menu{
	
	public static String accNumber;
	
	public WithdrawDeposit(String name) {
		super(name);
		addMenuItems("Withdraw");
		addMenuItems("Deposit");
		addMenuItems("View Transactions");
		addMenuItems("Transfer to account");
		addMenuItems("Return to Customer Menu");
	}
	
	public void getAccount() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Account number to make transaction: ");
		accNumber = sc.nextLine();
		System.out.println("Account Number: " + accNumber);
	}


	@Override
	void handleSelection() {
		AccountDaoImpl accdao = new AccountDaoImpl();
		switch (selection) {

		case 1:
			try {
				accdao.currentAccount().withdraw();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;

		case 2:
			
			try {
				accdao.currentAccount().deposit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
			
		case 3:
			try {
				accdao.currentAccount();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ViewAccounts.transactionsList();
			break;
		
		case 4:
			try {
				accdao.currentAccount().transfer();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		}
		
	}

}
