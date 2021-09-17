package com.revature.bankapp.menu;

import java.util.Scanner;

import com.revature.bankapp.form.EmployeeLogin;
import com.revature.bankapp.form.LoginForm;
import com.revature.bankapp.form.SignUp;
public class MainMenu extends Menu {

	public MainMenu(String name) {
		super(name);
		addMenuItems("Customer Signup");
		addMenuItems("Customer Login");
		addMenuItems("Employee Login");
		addMenuItems("Exit");

	}

	@Override
	void handleSelection() {
		switch (selection) {

		case 1:
			
			SignUp signUp = new SignUp("Customer SignUp");
			signUp.captureDataAndPerformAction();
			MainMenu mainMenu = new MainMenu("Main Menu");
			mainMenu.displayMenuLoop();
			break;

		case 2:
			
			LoginForm loginForm = new LoginForm("Customer Login");
			loginForm.captureDataAndPerformAction();
			CustomerMenu customerMenu = new CustomerMenu("Customer Menu");
			customerMenu.displayMenuLoop();
			break;
			
		case 3:
			EmployeeLogin empLogin = new EmployeeLogin("Admin Login");
			empLogin.captureDataAndPerformAction();
			break;
		
		case 4:
			System.out.println("********Thank you Visit Again **********");
			break;
		}
	
	}
}