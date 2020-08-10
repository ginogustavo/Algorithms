package array_hashtable_string;

/**
 * Determine if a string has all unique elements
 * 
 * @author Gustavo
 *
 */
public class IsUnique {
	public static void main(String[] args) {
		String string = "abcdefgha";
		System.out.println(new IsUnique().isUnique(string));
		System.out.println(new IsUnique().isUnique2(string));

	}

	private boolean isUnique(String string) {
		for (int i = 0; i < string.length() - 1; i++) {
			char c = string.charAt(i);
			int index = string.substring(i + 1).indexOf(c);
			if (index != -1)
				return false;
		}
		return true;
	}

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

}