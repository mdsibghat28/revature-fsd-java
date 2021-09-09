
public class InfosysTest {

	public static void main(String[] args) {
		
//		int[] array = {2, 3 , 1 , 1, 4};
		int[] array = {3, 2 , 1 , 0, 4};

		for( int i = 0; i < array.length; i++) {
			
			i += array[i];
			if (i == array.length-1) {
				System.out.println("True");
				System.exit(0);
			}

		}
		System.out.println("False");
		


	}

}
