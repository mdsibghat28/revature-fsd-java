import java.util.Scanner;
public class FahrenheitToCelsius {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the temperature in Fahrenheit");
		float fahrenheit = input.nextFloat();
		
		float celsius = (fahrenheit - 32) * 5/9f;
		
		System.out.println("Temperature in Celsius = "+ celsius);

	}

}
