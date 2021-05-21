package book.c1_array_strings;

import java.util.Hashtable;
import java.util.Map;

public class C1_4_Palindrome_Permutation {

	public static void main(String[] args) {

		String text = "tact coa";
		System.out.println(new C1_4_Palindrome_Permutation().validPalindrome(text));

	}

	// Method 1: check duplicates (author)

	private boolean validPalindrome(String text) {

		Map<Character, Integer> duplicates = new Hashtable<>();

		for (int i = 0; i < text.length(); i++) {

			Character letter = text.charAt(i);
			if (letter != ' ') { // ignore non letters characters
				if (duplicates.containsKey(letter)) {
					duplicates.remove(letter);
				} else {
					duplicates.put(letter, 1);
				}
			}
		}
		return duplicates.size() <= 1;

	}
}
