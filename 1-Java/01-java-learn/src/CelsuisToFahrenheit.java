import java.util.Scanner;
public class CelsuisToFahrenheit {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter temperature in celsius");
		float celsiusTemp = input.nextFloat();
		
		float fahrenheitTemp = (celsiusTemp * 9/5f) + 32;
		System.out.println("Temperature in Fahrenheit = " + fahrenheitTemp);
		
		input.close();
	}

}
