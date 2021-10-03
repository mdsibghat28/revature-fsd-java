package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.CustomerDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.exception.AppException;
import com.revature.bankapp.model.Customer;

public class CustomerDaoImpl implements CustomerDao {
	
	public static int currentCustomerId;
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDaoImpl.class);

	public Customer get(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(Customer customer) throws AppException {
		LOGGER.info("Start");
		LOGGER.debug("{}", customer);
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into customer (first_name, last_name, email, password) values (?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getLastName());
			statement.setString(3, customer.getEmail());
			statement.setString(4, customer.getPassword());
			statement.executeUpdate();
			LOGGER.info("END");
		} catch (SQLException e) {
			LOGGER.error("Error creating customer", e);
			throw new AppException(e);
		}

	}                                                          

	public void update(Customer customer) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void delete(int id) throws SQLException {
		// TODO Auto-generated method stub

	}
	
	public Customer getCustomerUserId(String email) throws SQLException {
		Customer customer = null;
		
		try (Connection connection = Util.getConnection()){
			String sql = "select * from customer where email = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1,  email);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				currentCustomerId = resultSet.getInt("id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String userid = resultSet.getString("email");
				String password = resultSet.getString("password");
				
				customer = new Customer(currentCustomerId, firstName, lastName, userid, password);
			}
		}
		return customer;
		
	}
	
	public Customer getCurrentCustomer() throws SQLException {
		Customer customer = null;
		
		try (Connection connection = Util.getConnection()){
			String sql = "select * from customer where id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1,  currentCustomerId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String userid = resultSet.getString("email");
				String password = resultSet.getString("password");
				
				customer = new Customer(id, firstName, lastName, userid, password);
			}
		}
		return customer;
		
	}


}
