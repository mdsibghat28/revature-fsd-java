package com.revature.bankapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.bankapp.dao.AccountDao;
import com.revature.bankapp.dao.Util;
import com.revature.bankapp.menu.TransactionMenu;
import com.revature.bankapp.model.Account;
import com.revature.bankapp.model.Transaction;
import com.revature.bankapp.model.ViewAccountsAndTransaction;


public class AccountDaoImpl implements AccountDao {
public static int currentAccountId;
public static int transferAccountId;

	@Override
	public void create(Account account) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "INSERT INTO account ( account_number,name, branch, balance, customer_id) VALUES (?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, account.getAccountNumber());
			preparedStatement.setString(2, account.getName());
			preparedStatement.setString(3, account.getBranch());
			preparedStatement.setLong(4, account.getBalance());
			preparedStatement.setInt(5, CustomerDaoImpl.currentcustomerid);
			preparedStatement.executeUpdate();

		}

	}

	@Override
	public List<Account> showAccounts() throws SQLException {
		List<Account> accountList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select account_number, branch, name, balance from account  where customer_id=(?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setInt(1, CustomerDaoImpl.currentcustomerid);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Account account = new Account();
				account.setBalance(rs.getInt("balance"));
				 account.setAccountNumber(rs.getString("account_number"));
				 account.setName(rs.getString("name"));
				 account.setBranch(rs.getString("branch"));
				accountList.add(account);
			}
		}
		return accountList;
	}
	
	
	public Account currentAccount() throws SQLException {
		Account account = null;
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where account_number = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, TransactionMenu.accNumber);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				currentAccountId = resultSet.getInt("account_id");
				String accNumber = resultSet.getString("account_number");
				Long balance = resultSet.getLong("balance");

				account = new Account(accNumber, balance);
			}
		}
		return account;
	}

	public void insert(Transaction transaction) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into transaction (type, amount, account_id) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, String.valueOf(transaction.getType()));
			statement.setDouble(2, transaction.getAmount());
			statement.setInt(3, currentAccountId);
			statement.executeUpdate();

		}

	}

	public void insertTransfer(Transaction transaction) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "insert into transaction (type, amount, account_id) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, String.valueOf(transaction.getType()));
			statement.setDouble(2, transaction.getAmount());
			statement.setInt(3, transferAccountId);
			statement.executeUpdate();
		}
	}

	public void update(Account account) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "update account set balance = ? where account_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, account.getBalance());
			statement.setInt(2, currentAccountId);
			statement.executeUpdate();
		}
	}

	public List<Transaction> transactionList() throws SQLException {
		List<Transaction> transactionList = new ArrayList<>();
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from transaction where account_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, currentAccountId);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Transaction transaction = new Transaction();
				transaction.setType(resultSet.getString("type").charAt(0));
				transaction.setAmount(resultSet.getDouble("amount"));
				transactionList.add(transaction);

			}
		}

		return transactionList;

	}

	public void updateTransfer(Account account) throws SQLException {
		try (Connection connection = Util.getConnection()) {
			String sql = "update account set balance = ? where account_id = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, account.getBalance());
			statement.setInt(2, transferAccountId);
			statement.executeUpdate();
		}
	}

	public Account transferAccount() throws SQLException {
		Account account = null;
		try (Connection connection = Util.getConnection()) {
			String sql = "select * from account where account_number = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, TransactionMenu.transferaccnumber);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				transferAccountId = resultSet.getInt("account_id");
				String accNumber = resultSet.getString("account_number");
				Long balance = resultSet.getLong("balance");

				account = new Account(accNumber, balance);
			}
		}
		return account;
}
}