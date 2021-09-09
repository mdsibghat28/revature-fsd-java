package com.revature.bankapp.form;

import java.util.Scanner;

import com.revature.bankapp.menu.CustomerMenu;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.DataManager;

public class LoginForm extends Form{
	
	private String userId;
	private String password;

	public LoginForm(String name) {
		super(name);
		
	}

	@Override
	public void captureData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("UseId : ");
		userId = sc.nextLine();

		System.out.println("Password : ");
		password = sc.nextLine();
	}

	@Override
	public void action() {
		
		Customer customer = DataManager.getCustomerUserId(userId);
		if (customer == null) {
			System.out.println("Invalid email or Password");
		}
		else if (customer.getPassword().equals(password)) {
			success = true;
			System.out.println("Login Successfull");
			System.out.println("Welcome " + customer.getName());
			CustomerMenu customerMenu = new CustomerMenu("Customer Menu");
			customerMenu.displayMenuLoop();
		} else {
			System.out.println("Invalid Username or Password");
		}
		
	}

}
