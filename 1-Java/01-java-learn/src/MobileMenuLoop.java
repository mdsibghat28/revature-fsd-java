import java.util.Scanner;

public class MobileMenuLoop {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		while (i == 0 ) {
			System.out.println("Menu");
			System.out.println("********");
			System.out.println("1. Balanca Enquiry");
			System.out.println("2. Recharge");
			System.out.println("3. Change Caller tune");
			System.out.println("4. Exit");
			System.out.println("Choose an option");
			int option = sc.nextInt();
			switch (option) {
			case 1: 
				System.out.println("Balance Enquiry");
				break;
			case 2: 
				System.out.println("Recharge");
				break;		
			case 3: 
				System.out.println("Change Caller Tune");
				break;		
			case 4:
				System.out.println("Exit");
				continue;			
			}
			
			continue;

		}

		
	}

}
