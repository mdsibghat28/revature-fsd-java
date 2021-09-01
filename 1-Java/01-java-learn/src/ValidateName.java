import java.util.Scanner;
public class ValidateName {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a short name");
		String name = input.nextLine();
		
		if (name.length() > 1 && name.length() < 7) {
			System.out.println("Valid short name");
		} else {
			System.out.println("Not a valid short name");
		}

	}

}
