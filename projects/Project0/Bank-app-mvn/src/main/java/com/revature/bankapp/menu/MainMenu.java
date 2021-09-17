package com.revature.bankapp.menu;

import java.util.Scanner;

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
			break;

		case 2:
			
			LoginForm loginForm = new LoginForm("Customer Login");
			loginForm.captureDataAndPerformAction();
			break;
			
		case 3:
			System.out.println("******* Work in Progress **********");
			break;
		
		case 4:
			System.out.println("********Exit Successfull. **********");
			break;
		}
	
	}
}