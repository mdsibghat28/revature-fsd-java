package com.revature.bankapp.model;

import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.accounts.Account;

public class DataManager {
	
	public static List<Customer> customerList = new ArrayList<>();
	
	public static List<Account> accountList = new ArrayList<>();
	
	public static void addCustomer(Customer customer) {
		
		customerList.add(customer);
	}
	
	public static void addAccount(Account account) {
		
		accountList.add(account);
	}
	
	public static Customer getCustomerUserId(String userId) {
		
		for (Customer customer : customerList) {
			if (customer.getUserId().equals(userId)) {
				return customer;
			}
		}
		return null;
	}

}
