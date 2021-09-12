package com.revature.bankapp.menu;

import com.revature.bankapp.accounts.ViewAccounts;
import com.revature.bankapp.form.CreateAccount;
import com.revature.bankapp.form.LoginForm;
import com.revature.bankapp.form.SignUp;

public class CustomerMenu extends Menu {

	public CustomerMenu(String name) {
		super(name);
		addMenuItems("Open New Account");
		addMenuItems("View Accounts");
		addMenuItems("Back to main menu");
		addMenuItems("Exit");

	}

	@Override
	void handleSelection() {
		System.out.println("Selected Option is: " + selection);
		switch (selection) {

		case 1:

			CreateAccount createAcc = new CreateAccount("Account details");
			createAcc.captureDataAndPerformAction();
			break;

		case 2:

			ViewAccounts.accountsList();
			break;

		case 3:
			MainMenu mainMenu = new MainMenu("Main Menu");
			mainMenu.displayMenuLoop();
			break;
			
		case 4:
			System.out.println("Thank you Visit again");
			break;
		}
	}
}
