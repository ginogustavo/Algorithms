package array_hashtable_string;

import java.util.Arrays;

/**
 * Determine if a string has all unique elements
 * 
 * @author Gustavo
 *
 */
public class C1_1_IsUnique {
	public static void main(String[] args) {
		String string = "abcdefghi";
		System.out.println(new C1_1_IsUnique().isUnique(string));
		System.out.println(new C1_1_IsUnique().isUnique2(string));
		System.out.println(new C1_1_IsUnique().isUnique3(string));
		System.out.println(new C1_1_IsUnique().isUnique4(string));

	}

	/**
	 * Method1 O(n)
	 */
	private boolean isUnique(String string) {
		for (int i = 0; i < string.length() - 1; i++) {
			char c = string.charAt(i);
			int index = string.substring(i + 1).indexOf(c);
			if (index != -1)
				return false;
		}
		return true;
	}

	/**
	 * Method 2 O(c)
	 */
	private boolean isUnique2(String string) {
		return validateStr(string.substring(1), string.charAt(0));

	}
	private boolean validateStr(String string, char c) {
		System.out.println("Str: " + string + " - char: " + c);

		if (string.length() <= 0)
			return true;

		if (string.indexOf(c) != -1)
			return false;

		return validateStr(string.substring(1), string.charAt(0));
	}

	/**
	 * BOOK
	 * Ask if it's ASCII or UNICODE. Assuming ASCII
	 */
	private boolean isUnique3(String str) {
		if(str.length()>128)return false;
		
		boolean[] ascii = new boolean[128];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if(ascii[val])return false;
			
			ascii[val] = true;
		}
		return true;
	}
	
	/**
	 * We could sort the string, and check if each character == neighbor  (n log n)
	 * However, "this is not optimal", since We should be allowed to modify the input, 
	 * and many sorting algorithms take up extra space.
	 */
	
	private String sortString(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	private boolean isUnique4(String str) {
		if(str.length()>128) return false;
		str = sortString(str);
		
		for (int i = 0; i < str.length()-1; i++) {
			int asciiVal1 = str.charAt(i);
			int asciiVal2 = str.charAt(i+1);
			if (asciiVal1 == asciiVal2)return false; 
		}
		return true;
	}
	
	
}