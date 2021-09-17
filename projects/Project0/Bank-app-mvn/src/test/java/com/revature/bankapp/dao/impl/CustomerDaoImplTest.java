package com.revature.bankapp.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.model.Customer;

class CustomerDaoImplTest {

	@Test
	void testCreate() {
		CustomerDao dao = new CustomerDaoImpl();
		Customer customer = new Customer("sib", "sib123", "123", null);
		try {
			dao.create(customer);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}

	}

}
