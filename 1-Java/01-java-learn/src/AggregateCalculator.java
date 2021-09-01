
public class AggregateCalculator {

	public static void main(String[] args) {
		float[] scores = {48, 55, 92, 78, 64};
		float total = 0.0f;

//		for (int i =0; i < scores.length; i++) {
//			total += scores[i]; 
//		}
		
		for (float score : scores) {
			total += score;
		}
		System.out.println("Average = "+ total/scores.length);
		

	}

}
