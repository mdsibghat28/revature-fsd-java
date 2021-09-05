
public class Transaction {
	
	private char type;
	private double amount;

	public Transaction(char type, double amount) {
		this.type = type;
		this.amount = amount;
	}
	
	public void displayTransaction(double balance) {
		System.out.printf("%4c %12.2f %9.2f\n", type, amount, balance);
	}
	
	
	
	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public static void main(String args[]) {
		Transaction transaction1 = new Transaction('W', 2000);
		Transaction transaction2 = new Transaction('D', 20000);
		Transaction transaction3 = new Transaction('D', 500);
		Transaction transaction4 = new Transaction('W', 15500);
		Transaction transaction5 = new Transaction('W', 10000);
		
		Transaction[] transactionList = {transaction1, transaction2, transaction3, transaction4, transaction5 };
		
		for (Transaction transaction: transactionList) {
			transaction.displayTransaction(5000);
		}
	}
}
