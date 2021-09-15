package com.revature.bankapp.accounts;

import java.util.ArrayList;

import com.revature.bankapp.model.DataManager;

public class ViewAccounts {

	public static ArrayList<Account> accountsList() {
		
		return DataManager.currentCustomer().getAccountList();
	}
}