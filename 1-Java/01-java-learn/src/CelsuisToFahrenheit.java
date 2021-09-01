import java.util.Scanner;
public class CelsuisToFahrenheit {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter temperature in celsius");
		float celsius = input.nextFloat();
		
		float fahrenheit = (celsius * 9/5f) + 32;
		System.out.println("Temperature in Fahrenheit = " + fahrenheit);
		
		input.close();
	}

}
