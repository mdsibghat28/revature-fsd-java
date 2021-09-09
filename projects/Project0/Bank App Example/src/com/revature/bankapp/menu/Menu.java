package com.revature.bankapp.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
	
	protected String name;
	protected List<String> menuItems;
	protected int selection;
	
	
	public Menu(String name) {
		this.name = name;
		menuItems = new ArrayList<>();
	}
	
	
	public void addMenuItems(String menuItemsName) {
		menuItems.add(menuItemsName);
	}
	
	public void displayMenuLoop() {
		boolean temp = true;
		while(temp) {
			try {
				displayMenuAndCapture();
				if (selection > 0 && selection <= menuItems.size()) {
					temp = false;
				} else {
					System.out.println("Select a valid option from the Menu");
				}
			} catch (NumberFormatException e) {
				System.out.println("Enter Valid Number");
			}
		}
	}
	
	public void displayMenu() {
		System.out.println("*************");
		System.out.println(name);
		System.out.println("*************\n");
		
		for (int i = 0; i < menuItems.size(); i++) {
			
			System.out.println((i+1) + ") " + menuItems.get(i));
			
		}
		
		System.out.print("Choose a Option: ");
	}
	
	public void captureSelection() {
		Scanner sc = new Scanner(System.in);
		selection = Integer.parseInt(sc.nextLine());
	}
	
	public void displayMenuAndCapture() {
		displayMenu();
		captureSelection();
		handleSelection();
	}
	
	abstract void handleSelection();

}
