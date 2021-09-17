package com.revature.bankapp.accounts;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.bankapp.dao.impl.AccountDaoImpl;

public class PendingAccounts {
	
	private boolean success;

	public void viewPending(){
		
		AccountDaoImpl accdao = new AccountDaoImpl();
		Scanner sc = new Scanner(System.in);
		
		try {
			List<Account> account = accdao.pendingList();
			for(int i = 0; i < account.size(); i++) {
				System.out.println(account.get(i).printId());
				int tempId = account.get(i).getId();
				success = true;
				while(success) {
					System.out.println("Approve (A) or Reject (R)");
					char choice = sc.nextLine().charAt(0);
					if(choice == 'A') {
						accdao.approveAccount(tempId);
						success = false;
					} else if(choice == 'R') {
						accdao.rejectAccount(tempId);
						success = false;
					} else {
						System.out.println("Enter valid input");
					}
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
