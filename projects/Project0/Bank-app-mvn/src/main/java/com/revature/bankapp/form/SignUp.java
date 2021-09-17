package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;
import com.revature.bankapp.model.Customer;

public class SignUp extends Form {
	
	private String name;
	private String userId;
	private String password;

	public SignUp(String name) {
		super(name);
		
	}

	@Override
	public void captureData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Name : ");
		name = sc.nextLine();

		System.out.println("UseId : ");
		userId = sc.nextLine();

		System.out.println("Password : ");
		password = sc.nextLine();
	}

	@Override
	public void action() {
		
		CustomerDao dao = new CustomerDaoImpl();
		try {
			dao.create(new Customer(name, userId, password));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Cannot create customer");
		}
		System.out.println("Registeration succesfully");
		success = true;
		
	}
	

}
