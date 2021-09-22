package com.revature.bankapp.menu;

import java.sql.SQLException;

import com.revature.bankapp.accounts.DisplayAccAndTrans;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.form.NewAccount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerMenu extends Menu {
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);
	
	AccountDaoImpl accdao = new AccountDaoImpl();

	public CustomerMenu(String name) {
		super(name);
		addMenuItems("Open New Account");
		addMenuItems("View Accounts");
		addMenuItems("Transactions");
		addMenuItems("LogOut");
		addMenuItems("Exit");

	}

	@Override
	void handleSelection() {
		CustomerMenu customerMenu = new CustomerMenu("Customer Menu");
		switch (selection) {

		case 1:

			NewAccount createAcc = new NewAccount("Account details");
			createAcc.captureDataAndPerformAction();
			customerMenu.displayMenuLoop();
			break;

		case 2:
			DisplayAccAndTrans.accountsList();
			customerMenu.displayMenuLoop();
			break;
			
		case 3:
			
			TransactionMenu wd = new TransactionMenu("Transaction Menu");
			String temp = wd.getAccount();
			try {
				if (accdao.validAccount(temp).getApproved() == 'Y') {
					wd.displayMenuLoop();
				} else {
					LOGGER.info("Account Not Approved");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			customerMenu.displayMenuLoop();

			
			break;

		case 4:
			MainMenu mainMenu = new MainMenu("Main Menu");
			mainMenu.displayMenuLoop();
			break;
			
		case 5:
			LOGGER.info("******Thank You Visit Again*******");
			break;
		}
	}
}
