package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.Util;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.menu.CustomerMenu;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.DataManager;

public class LoginForm extends Form{
	
	private String userId;
	private String password;
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

	public LoginForm(String name) {
		super(name);
		
	}
	

	@Override
	public void captureData() {
		Scanner sc = new Scanner(System.in);
		LOGGER.info("UserId : ");
		userId = sc.nextLine();

		LOGGER.info("Password : ");
		password = sc.nextLine();
	}

	@Override
	public void action() {
	
		CustomerDaoImpl dao = new CustomerDaoImpl();
		
		try {
			Customer customer = dao.getCustomerUserId(userId);
			if (customer == null) {
				System.out.println("Invalid User name or Password");
			}
			else if (customer.getPassword().equals(password)) {
				success = true;
				LOGGER.info("Login Successfull\n");
				System.out.println("Welcome " + customer.getName());
			} else {
				System.out.println("Invalid Username or Password");
			}
		} catch (SQLException e) {
			System.out.println("Login failed");
		}
		
		
	}

}
