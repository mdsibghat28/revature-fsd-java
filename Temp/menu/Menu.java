package com.revature.bankapp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
	protected String name;
	protected List<String> menuItems;// list is used to hold the menu itens list
	protected int selection; // since selection is an instance variable, so we write this-line number-35

	public Menu(String name) {
		this.name = name;
		menuItems = new ArrayList<String>(); // reason to use list is if it has an order, we get in ordered
		// these two lines are common for ever menu
	}

	public void addMenuItem(String menuItemName) {
		menuItems.add(menuItemName);
	}

	// now we can add display menu
	public void displayMenu() {
		System.out.println("\n***********************************");
		System.out.println(name);
		System.out.println("***********************************");
		for (int i = 0; i < menuItems.size(); i++) {
			System.out.println((i + 1) + ") " + menuItems.get(i));
		}
		System.out.print("Choose the option :");

	}

	public void captureSelection() { // here data is captured in this block
//		Scanner scanner = new Scanner(System.in);  //called display menu here
//	    selection = Integer.parseInt(scanner.nextLine());// scanner always use next line-remember this //selection -is an instance variable, see in line 11
		// handleAction();
//	    System.out.println("Selected option is: " + selection);					

		try {
			Scanner scanner = new Scanner(System.in);
			selection = Integer.parseInt(scanner.nextLine());
			System.out.println("Selected option is: " + selection);
			if (selection >= 1 && selection <= menuItems.size()) {

				handleAction();
			} else {
				System.out.println(" !!!Please enter valid option!!!  ");
				displayMenuAndCaptureSelection();
			}
		} catch (NumberFormatException e) {
			System.out.println("!!!Please enter valid option!!!");
		}

	}

	public void displayMenuAndCaptureSelection() {
		displayMenu();
		captureSelection();
	}

	abstract void handleAction();

}
