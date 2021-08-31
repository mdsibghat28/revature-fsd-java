import java.util.Scanner;
public class WebUrlChecker {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the website address");
		String url = input.nextLine();
		
		if (url.startsWith("http://") || url.startsWith("https://")) {
			System.out.println("This is a web URL");
		} else {
			System.out.println("This is not a web URL");
		}
		

	}

}
