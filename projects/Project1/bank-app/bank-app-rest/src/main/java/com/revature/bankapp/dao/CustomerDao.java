package com.revature.bankapp.dao;

import java.sql.SQLException;

import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Customer;

public interface CustomerDao {

	Customer get(int id) throws SQLException;

	void create(Customer customer) throws AppException;

	void update(Customer customer) throws SQLException;

	void delete(int id) throws SQLException;

}
