package com.revature.bankapp.dao;

import java.sql.SQLException;

import com.revature.bankapp.accounts.Account;

public interface AccountDao {
	
	void create(Account account) throws SQLException;

}
