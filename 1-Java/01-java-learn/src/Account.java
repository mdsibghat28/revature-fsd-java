
public class Account {
	
	private String accountNumber;
	private double balance;
	private Transaction[] transactions;
	
	public Account(String accountNumber, double balance, Transaction[] transactions) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.transactions = transactions;
	}
	
	public void printStatement() {
		System.out.println("Account Statement of " + accountNumber);
		System.out.println("Initial Balance: " + balance);
		
		System.out.println("\n---------------------------");
		System.out.println("Type  Transaction   Balance");
		System.out.println("---------------------------");
		
		for (Transaction transaction : transactions ) {
			
			if (transaction.getType() == 'W') {
				balance -= transaction.getAmount();
			} else if (transaction.getType() == 'D'){
				balance += transaction.getAmount();
			}
			
			transaction.displayTransaction(balance);
		}
		
		System.out.println("---------------------------");
	}
	
	public static void main(String args[]) {
		
		Transaction transaction1 = new Transaction('W', 2000);
		Transaction transaction2 = new Transaction('D', 20000);
		Transaction transaction3 = new Transaction('D', 500);
		Transaction transaction4 = new Transaction('W', 15500);
		Transaction transaction5 = new Transaction('W', 10000);
		
		Transaction[] transactionList = {transaction1, transaction2, transaction3, transaction4, transaction5 };
	
		Account account = new Account("1234567890", 5000.0, transactionList);
		account.printStatement();
	}
}
