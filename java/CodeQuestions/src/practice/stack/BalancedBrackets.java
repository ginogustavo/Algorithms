package practice.stack;

import java.util.*;
import java.util.stream.Stream;

/**
 * https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 * <p>
 * Given an expression string exp, write a program to examine whether
 * the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.
 * <p>
 * example:
 * Input: exp = “[()]{}{[()()]()}”
 * Output: Balanced
 * <p>
 * Input: exp = “[(])”
 * Output: Not Balanced
 */
public class BalancedBrackets {

    public static void main(String[] args) {
        BalancedBrackets app = new BalancedBrackets();
        //String exp = "[()]{}{[()()]()}";
        //String exp = "[(])";
        //String exp = "(()"; // should be false
        //String exp = "}()"; // should be false
        String exp = "()["; // should be false


        app.showBalanced(exp);
    }

    public void showBalanced(String exp) {
        System.out.println(exp + " =  " + (validateBalance(exp) ? "Balanced" : "Not Balanced"));
    }

    public boolean validateBalance(String exp) {
        Stack<Character> stack = new Stack<>();
        char[] array = exp.toCharArray();
        for (Character c : array) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char last = stack.pop();
                    if (
                            (c == ')' && last == '(') ||
                                    (c == ']' && last == '[') ||
                                    (c == '}' && last == '{')
                    ) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        if (stack.size() > 0)
            return false;
        else
            return true;
    }

}
