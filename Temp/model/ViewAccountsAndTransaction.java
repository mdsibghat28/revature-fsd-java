package com.revature.bankapp.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.menu.CustomerMenu;

public class ViewAccountsAndTransaction {
	

		public static ArrayList<Account> accountsList() {

			AccountDaoImpl accdao = new AccountDaoImpl();
			try {
				List<Account> accounts = accdao.showAccounts();
				for (int i = 0; i < accounts.size(); i++) {
					System.out.println((i + 1) + ") " + accounts.get(i));
				}
				CustomerMenu cm = new CustomerMenu("Customer Menu");
				cm.displayMenuAndCaptureSelection();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Cannot display accounts");
			}
			return null;
		}

		public static ArrayList<Transaction> transactionsList() {

			AccountDaoImpl accdao = new AccountDaoImpl();
			try {
				List<Transaction> transaction = accdao.transactionList();
				for (int i = 0; i < transaction.size(); i++) {
					System.out.println((i + 1) + ") " + transaction.get(i).print());
				}
				CustomerMenu cm = new CustomerMenu("Customer Menu");
				
				cm.displayMenuAndCaptureSelection();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Cannot display accounts");
			}
			return null;
		}
	}


