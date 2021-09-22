package com.revature.bankapp.accounts;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.bankapp.dao.Util;
import com.revature.bankapp.dao.impl.AccountDaoImpl;

public class DisplayAccAndTrans {
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);
	public static ArrayList<Account> accountsList() {

		AccountDaoImpl accdao = new AccountDaoImpl();
		try {
			List<Account> accounts = accdao.accountList();
			for (int i = 0; i < accounts.size(); i++) {
				LOGGER.info((i + 1) + ") " + accounts.get(i).print());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.info("Cannot display accounts");
		}
		return null;
	}

	public static ArrayList<Transactions> transactionsList() {

		AccountDaoImpl accdao = new AccountDaoImpl();
		try {
			List<Transactions> transaction = accdao.transactionList();
			for (int i = 0; i < transaction.size(); i++) {
				LOGGER.info((i + 1) + ") " + transaction.get(i).print());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LOGGER.info("Cannot display accounts");
		}
		return null;
	}
}