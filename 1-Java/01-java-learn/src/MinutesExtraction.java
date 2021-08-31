import java.util.Scanner;
public class MinutesExtraction {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the time in hh:mm:ss format");
		String time = input.next();
		
		String minutes = time.substring(3, 5);
		System.out.println("Minutes: "+ minutes);

	}

}
