package com.revature.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transactions;
import com.revature.bankapp.model.Customer;

public interface EmployeeDao {
	
	List<Customer> viewCustomer() throws SQLException;
	
	List<Account> viewAccount() throws SQLException;
	
	List<Transactions> viewTransaction() throws SQLException;

}
