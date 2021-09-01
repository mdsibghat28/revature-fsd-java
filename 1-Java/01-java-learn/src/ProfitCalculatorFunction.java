
public class ProfitCalculatorFunction {

	public static void main(String[] args) {
		System.out.println("Profit = "+ profitCalculator(50, 75));

	}
	public static int profitCalculator(int buyingPrice, int sellingPrice) {
		int profit = sellingPrice - buyingPrice;
		return profit;
	}

}
