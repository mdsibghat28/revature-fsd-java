package com.revature.bankapp.menu; //main menu is child class of menu

import java.util.Scanner;

import com.revature.bankapp.form.CustomerRegisterationForm;
import com.revature.bankapp.form.EmployeeLogin;
import com.revature.bankapp.form.LoginForm;
import com.revature.bankapp.model.Customer;



public class MainMenu extends Menu {

	public MainMenu(String name) { // theses two lines are constructor
		super(name);// generate superclass constructor here
		// TODO Auto-generated constructor stub

		addMenuItem("Register new Customer");
		addMenuItem("Login as Customer");
		addMenuItem("Login as Employee");
		addMenuItem("Exit");

	}

	@Override
	void handleAction() {
		Scanner scanner = new Scanner(System.in);
		switch (selection) {

		case 1:
			CustomerRegisterationForm customerRegistrationForm = new CustomerRegisterationForm("Customer Registration Form");
			customerRegistrationForm.captureDataAndPerformAction();
			displayMenuAndCaptureSelection();
			break;

		case 2:
			LoginForm loginForm = new LoginForm("Login Form");
			loginForm.captureDataAndPerformAction();
		//	displayMenuAndCaptureSelection(); create loop of Main Menu output.
			break;

		case 3:
			EmployeeLogin empLogin = new EmployeeLogin("Employee Login");
			empLogin.captureDataAndPerformAction();
			break;
		case 4:
			System.out.println("Closing The Application");
			break;

		}

	}

}
