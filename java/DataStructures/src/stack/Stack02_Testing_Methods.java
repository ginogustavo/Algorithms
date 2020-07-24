package stack;
import java.util.Stack;

public class Stack02_Testing_Methods {

	public static void main(String[] args) {
		Stack<String> stack1 = new Stack<String>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		stack1.push("a");
		stack1.push("b");
		stack1.push("c");

		stack2.add(1);
		stack2.add(2);
		stack2.add(3);

		/**
		 * Search() - returns the position of the element from the top of the stack if
		 * not found returns -1
		 */
		System.out.println(stack1.search("a"));
		System.out.println(stack1.search("b"));
		System.out.println(stack1.search("c"));
		System.out.println(stack1.search("d"));
		System.out.println(stack1.size());

		System.out.println(stack2.search(2));

		System.out.println(stack1);

		/**
		 * Contains return true or false
		 */
		System.out.println(stack2.contains(3));
		System.out.println(stack2.contains(4));

		Stack02_Testing_Methods app = new Stack02_Testing_Methods();
		app.test_set();

	}

	/**
	 * SET - is method from VECTOR class, so the index is not the position of the
	 * stack. be careful when setting using index.
	 */
	private void test_set() {

		// Adding using "ADD"
		Stack<String> stack = new Stack<String>();
		stack.add("Albert");
		stack.add("Bryan");
		stack.add("Charles");
		stack.add("Daniel");
		stack.add("Ethan");

		// Adding using "PUSH"
		Stack<String> stack2 = new Stack<String>();
		stack2.push("AAA");
		stack2.push("BBB");
		stack2.push("CCC");
		stack2.push("DDD");
		stack2.push("EEE");

		System.out.println(stack);
		System.out.println(stack2);

		System.out.println(stack.peek());
		System.out.println(stack2.peek());

		int s1 = stack.search("Bryan");
		System.out.println(s1);

		int s2 = stack2.search("BBB");
		System.out.println(s2);

		stack.set(s1, "Br__");
		stack2.set(s2, "BBB___");

		System.out.println(stack);
		System.out.println(stack2);
	}

}
