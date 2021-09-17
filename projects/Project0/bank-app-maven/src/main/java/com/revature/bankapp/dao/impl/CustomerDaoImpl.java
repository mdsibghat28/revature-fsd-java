package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.model.Customer;

public class CustomerDaoImpl implements CustomerDao{

	public int create(Customer customer) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into customer (name, user_id, password) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getUserId());
			statement.setString(3, customer.getPassword());
			statement.executeUpdate();
		}
		return 0;
		
	}

	public void update(Customer customer) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	public Customer get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
