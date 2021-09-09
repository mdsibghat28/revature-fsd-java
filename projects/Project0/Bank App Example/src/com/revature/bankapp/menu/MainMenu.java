package com.revature.bankapp.menu;

import java.util.Scanner;

import com.revature.bankapp.form.LoginForm;
import com.revature.bankapp.form.SignUp;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.DataManager;

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
		System.out.println("Selected Option is: " + selection);
		Scanner sc = new Scanner(System.in);
		switch (selection) {

		case 1:
			
			SignUp signUp = new SignUp("Customer SignUp");
			signUp.captureDataAndPerformAction();
			break;

		case 2:
			
			LoginForm loginForm = new LoginForm("Customer Login");
			loginForm.captureDataAndPerformAction();
			sc.close();
			break;
		}
	}
}