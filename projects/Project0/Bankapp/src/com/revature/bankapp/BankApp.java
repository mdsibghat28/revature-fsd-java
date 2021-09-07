package com.revature.bankapp;

import java.util.Scanner;

public class BankApp {
	private static String accountNumber;
	private static String name;
	private static String accountType;
	private static long balance;
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println("--------------------");
			System.out.println("1. Customer Login");
			System.out.println("2. Employee Login");
			System.out.println("3. Exit");
			System.out.println("--------------------");

			Scanner scanner = new Scanner(System.in);
			System.out.println("Choose an option");
			int option = scanner.nextInt();

			if (option == 1)

			{
				System.out.println("Enter Username");
				String username = scanner.next();

				System.out.println("Enter your Password");
				String password = scanner.next();

				System.out.println("Login Successful");
				System.out.println();
				System.out.println("Customer Menu");
				System.out.println("=========================");
				System.out.println("1.Create BankAccount ");
				System.out.println("2.Logout");
				System.out.println("choose an option");
				Scanner scanner1 = new Scanner(System.in);
				option = scanner1.nextInt();

				if (option == 1) {
					Scanner sc = new Scanner(System.in);
					System.out.println("Enter Account Number");
					accountNumber = scanner.next();
					System.out.println("Enter Account Name");
					name = scanner.next();
					System.out.println("Enter Account Type");
					accountType = scanner.next();
					System.out.println("Enter Account Balance");
					balance = scanner.nextLong();
				} else {
					System.out.println("logout");

				}

			}

			if (option == 2)

			{
				System.out.println("Enter Employee id");
				scanner.next();

				System.out.println("Enter your password");
				scanner.next();

			}

			if (option == 3) {
				System.out.println("Exit");
				System.exit(0);
			}

		}

	}
}
