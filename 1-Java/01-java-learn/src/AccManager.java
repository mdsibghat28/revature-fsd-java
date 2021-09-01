
public class AccManager {

	public static void main(String[] args) {
		System.out.println();calculateBalanceAndPrint('W', 2000.0, 5000.0);

	}
	public static double calculateBalanceAndPrint(char type, double transaction, double balance) {
		
		if (type == 'W') {
			balance -= transaction;
		} else if (type == 'D'){
			balance += transaction;
		}
		return balance;
	}

}
