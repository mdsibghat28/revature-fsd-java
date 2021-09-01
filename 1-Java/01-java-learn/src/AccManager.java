
public class AccManager {

	public static void main(String[] args) {
		String accountNumber = "1234567890";
		double balance = 5000.0;
		
		System.out.println("Account Statement of " + accountNumber);
		System.out.println("Initial Balance: " + balance);
		
		System.out.println("\n--------------------------");
		System.out.println("Type  Transaction  Balance");
		System.out.println("--------------------------");
		
		
		balance = calculateBalanceAndPrint('W', 2000.0, balance);
		balance = calculateBalanceAndPrint('D', 20000.0, balance);
		balance = calculateBalanceAndPrint('D', 500.0, balance);
		balance = calculateBalanceAndPrint('W', 15500.0, balance);
		balance = calculateBalanceAndPrint('W', 10000.0, balance);
		

	}
	public static double calculateBalanceAndPrint(char type, double transaction, double balance) {
		
		if (type == 'W') {
			balance -= transaction;
		} else if (type == 'D'){
			balance += transaction;
		}
		System.out.printf("%4c %12.2f %8.2f\n", type, transaction, balance);
		return balance;
	}

}
