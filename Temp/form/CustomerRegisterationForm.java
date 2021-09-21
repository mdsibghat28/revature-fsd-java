package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.model.Customer;
//import com.revature.bankapp.model.DataManager;

public class CustomerRegisterationForm extends Form {

	public CustomerRegisterationForm(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void captureData() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter First Name:");
		String firstName = scanner.nextLine();
		System.out.print("Enter LastName:");
		String lastName = scanner.nextLine();
		System.out.print("Enter emailId:");
		String email = scanner.nextLine();
		System.out.print("Setup password:");
		String password = scanner.nextLine();

		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		try {
			customerDaoImpl.create(new Customer(firstName, lastName, email, password));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void action() {
		success = true;
		System.out.println("\n..........................");
		System.out.println("Registeration Successful . ");
		System.out.println("Welcome To Kotak Bank !!! ");
		//System.out.println("...........................");


	}
  }



