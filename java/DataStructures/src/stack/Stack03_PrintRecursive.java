package stack;
import java.util.Stack;

public class Stack03_PrintRecursive {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		printStack(stack);
	}

	private static void printStack(Stack<Integer> stack) {

		if (stack.isEmpty()) {
			return;
		}

		// pop to get the last element.
		int last_element = stack.pop();

		// print stack recursively
		printStack(stack);

		// print last element
		System.out.print(last_element + "  ");

		// push that last_element
		stack.push(last_element);
	}
}