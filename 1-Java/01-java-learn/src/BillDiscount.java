import java.util.Scanner;
public class BillDiscount {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the bill amount");
		int billAmount = input.nextInt();
		System.out.println("Enter the discount percentage");
		int discount = input.nextInt();
		
		float discountAmount = billAmount * discount / 100f;
		System.out.println("Dicount Amount = "+ discountAmount);

	}

}
