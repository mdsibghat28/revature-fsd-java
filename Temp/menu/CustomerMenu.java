package com.revature.bankapp.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.form.AccountRegistrationForm;
import com.revature.bankapp.model.Account;



public class CustomerMenu extends Menu {

	public CustomerMenu(String name) {
		super(name);
		addMenuItem("Create new Account");
		addMenuItem("View Accounts");
		addMenuItem("Transactions");
		addMenuItem("Logout");

	}

	@Override
	void handleAction() {
		Scanner scanner = new Scanner(System.in);
		switch (selection) {
		case 1:
			AccountRegistrationForm accountRegistrationForm = new AccountRegistrationForm("New Account registartion form");
			accountRegistrationForm.captureDataAndPerformAction();
			displayMenuAndCaptureSelection();
			break;
			
		case 2:
			System.out.println("These are Your Accounts"); //View Account
			AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
			try {
				ArrayList<Account> accountList = (ArrayList<Account>) accountDaoImpl.showAccounts();
				accountList.forEach(System.out::println);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 3:
			TransactionMenu transactionmenu = new TransactionMenu("Transaction Menu");
		    transactionmenu.getAccount();
			transactionmenu.displayMenuAndCaptureSelection();
			break;
				
		case 4:
			System.out.println("Logout");
			break;
		}

	}

}
