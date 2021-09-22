package com.revature.bankapp.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.revature.bankapp.accounts.Account;

class AccountDaoImplTest {
	
	Account account = new Account("123456789", 2000);
	AccountDaoImpl adao = new AccountDaoImpl();
	int tempId = 1;
	String temp;

	@Test
	void testCreate() {
		try {
			adao.approveAccount(tempId);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Test Failed");
		}
	}
	
	@Test 
	void testCurrentAccount() {
		try {
			adao.rejectAccount(tempId);
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Test Failed");
		}
	}
	
	@Test 
	void testPendingList() {
		try {
			adao.pendingList();
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Test Failed");
		}
	}
	
	@Test 
	void TestValidAccount() {
		try {
			adao.validAccount(temp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
