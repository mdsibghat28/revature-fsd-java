package com.revature.bankapp;

import java.util.Scanner;

public class MainMenu {

	public static void main(String[] args) {
		
		do {
			System.out.println("\n**********  Main Menu  ************");
			System.out.println("\nChoose an Option");
			System.out.println("1) Customer Login");
			System.out.println("2) SignUp");
			System.out.println("**********             ************");

			Scanner sc = new Scanner(System.in);
			
			int choice = sc.nextInt();
			
			if (choice == 1) {
				Login.LoginDetails();

				break;
			} else if (choice == 2) {
				Login.SignUp();

				break;
			} else {
				System.out.println("*****Enter a valid option******");
			}

		} while (true);
	}

}
