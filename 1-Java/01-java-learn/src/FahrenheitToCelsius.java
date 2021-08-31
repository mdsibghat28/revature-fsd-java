import java.util.Scanner;
public class FahrenheitToCelsius {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the temperature in Fahrenheit");
		float fahrenheitTemp = input.nextFloat();
		
		float celsiusTemp = (fahrenheitTemp - 32) * 5/9f;
		
		System.out.println("Temperature in Celsius = "+ celsiusTemp);

	}

}
