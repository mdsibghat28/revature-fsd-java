package com.revature.bankapp.form;

import java.util.Scanner;

import com.revature.bankapp.menu.MainMenu;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.DataManager;

public class SignUp extends Form {
	
	private String name;
	private String userId;
	private String password;

	public SignUp(String name) {
		super(name);
		
	}

	@Override
	public void captureData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name : ");
		name = sc.nextLine();

		System.out.println("UseId : ");
		userId = sc.nextLine();

		System.out.println("Password : ");
		password = sc.nextLine();
	}

	@Override
	public void action() {
		
		DataManager.addCustomer(new Customer(name, userId, password));
		System.out.println("Customer added succesfully");
		success = true;
		MainMenu mainMenu = new MainMenu("Main Menu");
		mainMenu.displayMenuLoop();
		
	}
	

}
