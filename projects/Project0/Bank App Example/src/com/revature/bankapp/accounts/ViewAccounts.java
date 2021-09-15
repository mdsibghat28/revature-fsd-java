package com.revature.bankapp.accounts;

import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.DataManager;

public class ViewAccounts {

	
	public static Account accountsList() {
		
		System.out.print("Account No         Balance");
		
		for (Account account : Customer.accountList) {
			
//				System.out.printf("%14s %10.2f\n", account.getAccountNumber(), account.getBalance());
			System.out.println(Customer.getAccountList());
			}
		return null;	
	}
	
}