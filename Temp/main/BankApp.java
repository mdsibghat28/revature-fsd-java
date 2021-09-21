package com.revature.bankapp.main;

import com.revature.bankapp.menu.MainMenu;
//import com.revature.bankapp.model.Customer;
import com.revature.bankapp.menu.CustomerMenu;


public class BankApp {

/*	private static Customer currentCustomer = null;

	public static Customer getCurrentCustomer() {
		return currentCustomer;
	}

	public static void setCurrentCustomer(Customer customer) {
		currentCustomer = customer; } */
	

	public static void main(String[] args) {
		// create an instance of main menu

		MainMenu menu = new MainMenu("Main Menu");
		menu.displayMenuAndCaptureSelection();

	}

}
