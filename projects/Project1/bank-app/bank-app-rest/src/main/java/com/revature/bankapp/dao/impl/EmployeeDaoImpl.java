package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transactions;
import com.revature.bankapp.dao.EmployeeDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.model.Customer;
import com.revature.bankapp.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public List<Customer> viewCustomer() throws SQLException {
		List<Customer> customerList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from customer";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Customer customerTemp = new Customer();
				customerTemp.setCustomerId(resultSet.getInt("id"));
				customerTemp.setFirstName(resultSet.getString("first_name"));
				customerTemp.setLastName(resultSet.getString("last_name"));
				customerTemp.setEmail(resultSet.getString("email"));
				customerList.add(customerTemp);
			}
		return customerList;
		}
	}

	@Override
	public List<Account> viewAccount() throws SQLException {
		List<Account> accountList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account order by customer_id";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Account accountTemp = new Account();
				accountTemp.setCustomerId(resultSet.getInt("customer_id"));
				accountTemp.setAccountId(resultSet.getInt("id"));
				accountTemp.setAccountNumber(resultSet.getInt("account_number"));
				accountTemp.setBalance(resultSet.getDouble("balance"));
				accountList.add(accountTemp);

			}
		}
		return accountList;
	}

	public List<Transactions> viewTransaction() throws SQLException {
		List<Transactions> transactionList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from transaction order by account_id";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Transactions transactionTemp = new Transactions();
				transactionTemp.setTransactionId(resultSet.getInt("id"));
				transactionTemp.setType(resultSet.getString("type").charAt(0));
				transactionTemp.setAmount(resultSet.getDouble("amount"));
				transactionTemp.setAccountId(resultSet.getInt("account_id"));
				transactionList.add(transactionTemp);

			}
		}
		return transactionList;
	}
	
	public Employee getEmployeeUserId(String userId) throws SQLException {
		Employee employee = null;
		
		try (Connection connection = Util.getConnection()){
			String sql = "select * from employee where email = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String userid = resultSet.getString("email");
				String password = resultSet.getString("password");
				
				employee = new Employee(name, userid, password);
			}
		}
		return employee;
	}

}
