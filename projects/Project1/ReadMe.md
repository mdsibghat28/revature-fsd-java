# Bank App

## Description

   The Bank app is a UI based application that simulates banking operations. A customer can apply for an account, view their balance, and make withdrawals and deposits. An employee can view account balances for their customers.
	

## Implementation
1. Functionality reflects the below user stories.
2. Data is stored in a database.
3. Data Access is performed through the use of JDBC in a data layer consisting of Data Access Objects.
4. All input is received using the java.util.Scanner class.
5. Log4j is implemented to log events to a file.
6. JUnit tests are written to test some functionality.


## User Stories

* As a user, I can login.
* As a customer, I can register with the bank using First Name, Last Name, Email and Password.
* As a customer, I can apply for a new bank account with a starting balance.
* As a customer, I can view the list of accounts I own showing the balance.
* As a customer, I can make a withdrawal or deposit to a specific account.
* As the system, I reject invalid transactions.
	* Ex:
		* A withdrawal that would result in a negative balance.
		* A deposit or withdrawal of negative money.
* As a customer, I can view the transactions in a specific account.
* As an employee, I can view a customer's bank accounts.
* As an employee, I can view transactions done by the customers account.
* As a user, I can logout.

