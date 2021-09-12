package com.revature.bankapp.accounts;

import com.revature.bankapp.model.DataManager;

public class ViewAccounts {

	
	public static Account accountsList() {
		
		System.out.print("Account No         Balance");
		
		for (Account account : DataManager.accountList) {
			
				System.out.printf("%14s %10.2f\n", account.getAccountNumber(), account.getBalance());
			}
		return null;	
	}
	
}