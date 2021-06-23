package problems.string;

import java.util.Stack;

public class RomanToInteger {
    public static void main(String[] args) {
        RomanToInteger app = new RomanToInteger();
        System.out.println(app.romanToInt("III"));
        System.out.println("\n=======================\n");
        System.out.println(app.romanToInt("IV"));
        System.out.println("\n=======================\n");
        System.out.println(app.romanToInt("IX"));
        System.out.println("\n=======================\n");
        System.out.println(app.romanToInt("LVIII"));
        System.out.println("\n=======================\n");
        System.out.println(app.romanToInt("MCMXCIV"));
        System.out.println("\n=======================\n");


    }

    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     */
    /**
     * Input: s = "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     */
    public int romanToInt(String s) {
        switch (c){

        }

        char[] array = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (Character c : array) {
            stack.push(c);
        }
        int total = 0;

        while(!stack.isEmpty()){
            char c = stack.pop();
            int number = getValue(c);
            total += number;
            if(stack.isEmpty()){
                break;
            }else{
                int prev = getValue(stack.peek());
                if(prev < number ){
                    char previous = stack.pop();
                    total -= getValue(previous);
                }
            }
        }

        return total;
    }

    public int getValue(char c){
        switch (c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            default: return 1000; //M
        }
    }
}
