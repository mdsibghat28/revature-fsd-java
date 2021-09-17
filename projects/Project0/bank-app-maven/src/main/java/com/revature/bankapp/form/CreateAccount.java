package com.revature.bankapp.form;

import java.util.Scanner;

import com.revature.bankapp.accounts.Account;
import com.revature.bankapp.menu.CustomerMenu;

public class CreateAccount extends Form {

	private String accountNumber;
	private double initialAmount;

	public CreateAccount(String name) {
		super(name);

	}

	@Override
	public void captureData() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Account Number: ");
		accountNumber = sc.nextLine();

		System.out.print("Enter the intial deposit amount: ");
		initialAmount = sc.nextDouble();

	}

	@Override
	public void action() {
		System.out.println("Account created successfully ");
//		try {
//		DataManager.addAccount(new Account(accountNumber, initialAmount));
//		} catch (NullPointerException e) {
//			System.out.println("Exception");
//		}
//		Customer.addAccount(new Account(accountNumber, initialAmount));

		LoginForm.getCurrentCustomer().addAccount(new Account(accountNumber, initialAmount));
		CustomerMenu customerMenu = new CustomerMenu("Customer Menu");
		customerMenu.displayMenuLoop();
		success = true;

	}

}
