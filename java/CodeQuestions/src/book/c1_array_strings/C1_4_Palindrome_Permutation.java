package book.c1_array_strings;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.stream.Stream;

public class C1_4_Palindrome_Permutation {

    public static void main(String[] args) {

        String text = "tact coa";
//		String text = "abbbba";
//		String text = "abbbbca";
//		String text = "abbbbcadd";
//		String text = "tactcoapapa";
//		String text = "tact coa";
//		String text = "tact coa";
//		String text = "tact coa";


        //System.out.println(new C1_4_Palindrome_Permutation().validPalindrome(text));
//		System.out.println(new C1_4_Palindrome_Permutation().validPalindrome1(text));
        System.out.println(new C1_4_Palindrome_Permutation().validPalindrome3(text));


    }

    // Method 2: check duplicates (author)

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

    /**
     * First try O(n)
     */
    private boolean validPalindrome1(String text) {
        text = text.replaceAll("\\s", "");
        Map<Character, Integer> map = new HashMap<>();
        int oddCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                map.replace(c, ++count);
                if (count % 2 != 0)
                    oddCount++;
                else
                    oddCount--;
            } else {
                map.put(c, 1);
                oddCount++;
            }
        }
        return oddCount <= 1;
    }


    private boolean validPalindrome3(String text) {
        text = text.replaceAll("\\s", "");
        int[] arr = new int[Character.getNumericValue('z') - Character.getNumericValue('a') - 1];
        int countOdd = 0;
        for (Character c : text.toCharArray()) {
            int value = getCharacterNumber(c);
            if (value != -1) {
                arr[value]++;
                if (arr[value] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }

        return countOdd <= 1;
    }

    private int getCharacterNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int c_value = Character.getNumericValue(c);

        if (c_value >= a && c_value <= z) {
            return c_value - a;
        } else {
            return -1;
        }
    }
}
