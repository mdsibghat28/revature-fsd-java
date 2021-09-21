package com.revature.bankapp.menu;

import java.sql.SQLException;

import com.revature.bankapp.accounts.DisplayAccAndTrans;
import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.form.CreateAccount;

public class CustomerMenu extends Menu {
	
	AccountDaoImpl accdao = new AccountDaoImpl();

	public CustomerMenu(String name) {
		super(name);
		addMenuItems("Open New Account");
		addMenuItems("View Accounts");
		addMenuItems("Transactions");
		addMenuItems("Back to main menu");
		addMenuItems("Exit");

	}

	@Override
	void handleSelection() {
		switch (selection) {

		case 1:

			CreateAccount createAcc = new CreateAccount("Account details");
			createAcc.captureDataAndPerformAction();
			CustomerMenu customerMenu = new CustomerMenu("Customer Menu");
			customerMenu.displayMenuLoop();
			break;

		case 2:
			DisplayAccAndTrans.accountsList();
			break;
			
		case 3:
			
			WithdrawDeposit wd = new WithdrawDeposit("Transaction Menu");
			String temp = wd.getAccount();
			try {
				if (accdao.validAccount(temp).getApproved() == 'Y') {
					wd.displayMenuLoop();
				} else {
					System.out.println("Account Not Approved");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			
			break;

		case 4:
			MainMenu mainMenu = new MainMenu("Main Menu");
			mainMenu.displayMenuLoop();
			break;
			
		case 5:
			System.out.println("Thank you Visit again");
			break;
		}
	}
}
