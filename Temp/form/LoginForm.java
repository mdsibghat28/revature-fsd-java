package com.revature.bankapp.form;

import java.sql.SQLException;
import java.util.Scanner;
import com.revature.bankapp.menu.CustomerMenu;
//import com.revature.bankapp.menu.TransactionMenu;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.dao.impl.CustomerDaoImpl;


public class LoginForm extends Form {

	private String email;
	private String password;

	public LoginForm(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void captureData() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Email:  ");
		email = scanner.nextLine();

		System.out.print("Password: ");
		password = scanner.nextLine();
	}

	@Override
	public void action() {
		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
		Customer customer;
		try {
			customer = customerDaoImpl.getCustomerByEmail(email);
			if (customer == null) {
				System.out.println("Invalid Password or Email");
			} else if (customer.getPassword().equals(password)) {
				success = true;
				System.out.println("Login Successful");
				System.out.println("Welcome " + customer.getFirstName());
				CustomerMenu customerMenu = new CustomerMenu("Customer Menu");
				customerMenu.displayMenuAndCaptureSelection();

			} else {
				System.out.println("Invalid Password or Email");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}


 /*@Override
 public void action() {
   //Customer customer = DataManager.getCustomerByEmail(email);//use dao 
   if (customer == null) {
  System.out.println("Invalid email / password");
   } 
   else if (customer.getPassword().equals(password))
    { 
    success = true;
  System.out.println("Login Successful."); 
  System.out.println("Welcome " + customer.getFirstName()); 
  TransactionMenu transactionmenu = new TransactionMenu ("Customer Menu");
  transactionmenu.displayMenuAndCaptureSelection();
  }else
   { 
   System.out.println("Invalid email / password ");
    }
    }
      }*/
 
