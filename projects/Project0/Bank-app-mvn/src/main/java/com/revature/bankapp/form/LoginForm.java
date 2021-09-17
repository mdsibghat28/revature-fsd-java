package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.menu.CustomerMenu;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.DataManager;

public class LoginForm extends Form{
	
	private String userId;
	private String password;

	public LoginForm(String name) {
		super(name);
		
	}
	

	@Override
	public void captureData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("UserId : ");
		userId = sc.nextLine();

		System.out.println("Password : ");
		password = sc.nextLine();
	}

	@Override
	public void action() {
		
//		Customer customer = DataManager.getCustomerUserId(userId);
		CustomerDaoImpl dao = new CustomerDaoImpl();
		
		try {
			Customer customer = dao.getCustomerUserId(userId);
			if (customer == null) {
				System.out.println("Invalid User name or Password");
			}
			else if (customer.getPassword().equals(password)) {
				success = true;
				DataManager.setcurrentCustomer(customer);
				System.out.println("Login Successfull\n");
				System.out.println("Welcome " + customer.getName());
				CustomerMenu customerMenu = new CustomerMenu("Customer Menu");
				customerMenu.displayMenuLoop();
			} else {
				System.out.println("Invalid Username or Password");
			}
		} catch (SQLException e) {
			System.out.println("Login failed");
		}
		
		
	}

}
