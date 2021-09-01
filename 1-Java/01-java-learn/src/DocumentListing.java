
public class DocumentListing {

	public static void main(String[] args) {
		String[] docs = {"Driving License", "Passport", "Last 3 months Bak statement", "Salary slip of last 3 months", "2 passport size photos"};
		
		for (int i = 0; i < docs.length; i++) {
			
			System.out.println(i+1 + ") " + docs[i]);
		}

	}

}
