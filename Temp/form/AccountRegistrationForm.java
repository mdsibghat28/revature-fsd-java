package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.bankapp.dao.impl.AccountDaoImpl;
import com.revature.bankapp.model.Account;


public class AccountRegistrationForm extends Form{

	public AccountRegistrationForm(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void captureData() {
	
		System.out.print("account number :");
		String an = scanner.next();
		
		System.out.print("Enter Name : ");
		String name = scanner.next();
		
		System.out.print("Enter Branch name : ");
		String branch = scanner.next();
		
		System.out.print("Enter starting balance : ");
		long balance = scanner.nextLong();
		
		AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
		try {
			accountDaoImpl.create(new Account(an, name, branch, balance ));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void action() {
		success = true;
		
	}
	
}