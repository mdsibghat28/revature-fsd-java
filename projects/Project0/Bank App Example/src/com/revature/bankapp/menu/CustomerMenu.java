package com.revature.bankapp.menu;


public class CustomerMenu extends Menu {

	public CustomerMenu(String name) {
		super(name);
		addMenuItems("Open New Account");
		addMenuItems("View Accounts");
		addMenuItems("Exit");
		
	}

	@Override
	void handleSelection() {
		System.out.println("Selected Option is: " + selection);
		
	}

}
