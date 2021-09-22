package com.revature.bankapp.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.model.Customer;

class CustomerDaoImplTest {
	
	Customer customer = new Customer("Sibghat", "sibghat123", "123456");
	CustomerDaoImpl dao = new CustomerDaoImpl();


	@Test
	void testCreate() {
		try {
			dao.create(customer);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}

	}
	
	@Test 
	void testGetCustomer() {
		try {

			dao.getCustomerUserId("sibghat123");
		} catch (SQLException e) {
			e.printStackTrace();
			fail("No data found");
		}

	}

}
