package array_hashtable_string;

import java.util.Arrays;

public class C1_2_CheckPermutation {

	public static void main(String[] args) {
		C1_2_CheckPermutation app = new C1_2_CheckPermutation();
		String s1 = "abc";
		String s2 = "bcc";
		System.out.println(app.checkPermutation(s1, s2));
		System.out.println(app.checkPermutation2(s1, s2));
		System.out.println(app.checkPermutation3(s1, s2));

	}

	/*
	 * O(n)
	 */
	private boolean checkPermutation(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		for (int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if (s2.indexOf(c) == -1) {
				return false;
			}
		}
		return true;
	}
	// sort both and compare if they are equals?

	// BOOK

	/**
	 * Method 1: sort both and compare if they are equal: Not optimal, but it's
	 * clean
	 */
	private String sortString(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	private boolean checkPermutation2(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		return sortString(s1).equals(sortString(s2));
	}

	/**
	 * Method 2: check if both have the identical character counts. We increment
	 * through the first string and decrement through the second one. If they are
	 * permutation, they all will be zero.
	 */

	private boolean checkPermutation3(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		int[] ascii = new int[128]; // <- Assuming ASCII, UNICODE 256
		for (int i = 0; i < s1.length(); i++) {
			ascii[s1.charAt(i)]++;
		}

		for (int i = 0; i < s2.length(); i++) {
			ascii[s2.charAt(i)]--;
			if (ascii[s2.charAt(i)] < 0) { // if single negative,
				return false;
			}
		}
		return true; // letters has no neg values, therefore no pos values either.

	}
}
