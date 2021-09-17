package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	public static int currentCustomerId;

	public Customer get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(Customer customer) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into customer (name, user_id, password) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getUserId());
			statement.setString(3, customer.getPassword());
			statement.executeUpdate();
		}

	}

	public void update(Customer customer) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}
	
	public Customer getCustomerUserId(String userId) throws SQLException {
		Customer customer = null;
		
		try (Connection connection = Util.getConnection()){
			String sql = "select * from customer where user_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,  userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				currentCustomerId = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String userid = resultSet.getString("user_id");
				String password = resultSet.getString("password");
				
				customer = new Customer(name, userid, password);
			}
		}
		return customer;
		
	}

}
