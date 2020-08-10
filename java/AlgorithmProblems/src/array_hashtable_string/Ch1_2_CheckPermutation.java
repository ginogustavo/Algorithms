package array_hashtable_string;

public class Ch1_2_CheckPermutation {

	public static void main(String[] args) {
		Ch1_2_CheckPermutation app = new Ch1_2_CheckPermutation();
		String s1 = "abc";
		String s2 = "bcb";
		System.out.println(app.checkPermutation( s1, s2));
	}
	
	//sort both and compare if they are equals?
	
	private boolean checkPermutation(String s1, String s2) {
		if (s1.length() != s2.length()) return false;
			
		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (s2.indexOf(c)== -1) {
				return false;
			}	
		}
		return true;
	}
}
