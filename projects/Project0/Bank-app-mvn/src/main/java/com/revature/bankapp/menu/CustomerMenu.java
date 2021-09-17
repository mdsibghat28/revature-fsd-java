package com.revature.bankapp.menu;

import com.revature.bankapp.accounts.ViewAccounts;
import com.revature.bankapp.form.CreateAccount;

public class CustomerMenu extends Menu {

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
			ViewAccounts.accountsList();
			break;
			
		case 3:
			
			WithdrawDeposit wd = new WithdrawDeposit("Transaction Menu");
			wd.getAccount();
			wd.displayMenuLoop();
			
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
