package com.revature.bankapp.menu;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.accounts.Account;
import com.revature.bankapp.accounts.PendingAccounts;
import com.revature.bankapp.accounts.Transactions;
import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.impl.EmployeeDaoImpl;
import com.revature.bankapp.form.CreateAccount;
import com.revature.bankapp.form.LoginForm;
import com.revature.bankapp.form.SignUp;
import com.revature.bankapp.model.Customer;

public class EmployeeMenu extends Menu{

	public EmployeeMenu(String name) {
		super(name);
		addMenuItems("Register for Customer account");
		addMenuItems("View Customers");
		addMenuItems("View Accounts");
		addMenuItems("View Transactions");
		addMenuItems("Pending Accounts");
		addMenuItems("Logout");
		
	}

	@Override
	void handleSelection() {
		EmployeeDao edao = new EmployeeDaoImpl();
		switch(selection) {
		
		case 1:
			SignUp signUp = new SignUp("Customer SignUp");
			signUp.captureDataAndPerformAction();
			
			LoginForm loginForm = new LoginForm("Customer Login");
			loginForm.captureDataAndPerformAction();
			
			CreateAccount createAcc = new CreateAccount("Account details");
			createAcc.captureDataAndPerformAction();
			
			displayMenuLoop();
			
			break;
		case 2:
			try {
				List<Customer> list = edao.viewCustomer();
				for(int i =0; i <list.size(); i++) {
					System.out.println((i+1) + ") " + list.get(i));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			displayMenuLoop();
			break;
		case 3:
			try {
				List<Account> list = edao.viewAccount();
				for(int i =0; i <list.size(); i++) {
					System.out.println((i+1) + ") " + list.get(i));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			displayMenuLoop();
			break;
		case 4:
			try {
				List<Transactions> list = edao.viewTransaction();
				for(int i =0; i <list.size(); i++) {
					System.out.println((i+1) + ") " + list.get(i));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			displayMenuLoop();
			break;
			
		case 5:
			PendingAccounts pa = new PendingAccounts();
			pa.viewPending();
			
			break;
			
		case 6:
			MainMenu mm = new MainMenu("Main Menu");
			mm.displayMenuLoop();
			break;
		}
		
	}

}
