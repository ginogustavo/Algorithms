package array_hashtable_string;

public class C1_3_URLify {

	public static void main(String[] args) {

		String text = "Mr John Smith    ";
		char[] textCharArray = text.toCharArray();
		int realLenght = 13;
		// char[] replaced = new C1_3_URLify().replaceSpaces(textCharArray, realLenght);
		char[] replaced = new C1_3_URLify().replaceSpace(textCharArray, realLenght);

		System.out.println("Length: " + replaced.length);
		System.out.print("[");
		int counter = 0;
		for (char c : replaced) {

			System.out.print(c);
//			System.out.println(counter++);
		}
		System.out.println("]");

		//When full string is provided..
		System.out.println("-"+C1_3_URLify.urify("Mr John Smith      ")+"-");
	}

	private static String urify(String str){
		String s = str.stripTrailing();
		StringBuilder sb = new StringBuilder(str.length());

		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==' '){
				sb.append("%20");
			}else{
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

	public char[] replaceSpaces(char[] str, int trueLenght) {

		char[] finalChar = new char[trueLenght * 3];
		System.out.println("Lengt initial: " + finalChar.length);

		int finalCounter = 0;

		for (int i = 0; i < str.length; i++) {
			char c = str[i];
			if (c == ' ') {
				finalChar[finalCounter] = '%';
				finalChar[++finalCounter] = '2';
				finalChar[++finalCounter] = '0';

			} else {
				finalChar[finalCounter] = str[i];
			}
			finalCounter++;

		}

		return finalChar;
	}

	// Method 2:
	// Edit string starting from the end and working backwards.
	// first count spaces

	char[] replaceSpace(char[] str, int trueLength) {
		// getting number of spaces:
		int spaces = countOcurrence(str, 0, 13, ' ');
		int newIndex = trueLength - 1 + (spaces * 2);

		// If there is a excess of space, add null character.
		// to indicate the spaces after that point are not replaced with %20
		if (newIndex + 1 < str.length)
			str[newIndex + 1] = '\0';

		for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex -= 1) {
			if (str[oldIndex] == ' ') {
				str[newIndex] = '0';
				str[newIndex - 1] = '2';
				str[newIndex - 2] = '%';
				newIndex -= 3;
			} else {
				str[newIndex] = str[oldIndex];
				newIndex -= 1;
			}

		}

		return str;

	}

	int countOcurrence(char[] str, int start, int end, int target) {

		int counter = 0;
		for (int i = start; i < end; i++) {
			if (str[i] == target) {
				counter++;
			}
		}

		return counter;
	}

}
