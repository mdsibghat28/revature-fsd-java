package com.revature.bankapp.main;

import java.util.Scanner;

import com.revature.bankapp.menu.MainMenu;

public class BankApp {
	
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		MainMenu menu = new MainMenu("Main Menu");
		menu.displayMenuLoop();

	}
	
	public static Scanner getScanner() {
		return sc;
	}
	
}
