package com.revature.bankapp;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		

	}
	
	public static void LoginDetails() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Login");
		System.out.println("Enter the Username");
		sc.nextInt();
		System.out.println("Enter the Password");
		sc.nextInt();
		Customer.Menu();
	}

}
