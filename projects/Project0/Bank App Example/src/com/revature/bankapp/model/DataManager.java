package com.revature.bankapp.model;

import java.util.ArrayList;
import java.util.List;

public class DataManager {
	
	private static List<Customer> customerList = new ArrayList<>();
	
	public static void addCustomer(Customer customer) {
		
		customerList.add(customer);
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
