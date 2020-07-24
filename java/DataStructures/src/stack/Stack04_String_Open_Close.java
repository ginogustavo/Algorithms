package stack;
import java.util.Stack;

class Stack04_String_Open_Close {
	public static void main(String[] args) {
		System.out.println(new Stack04_String_Open_Close().isValid("{[]}"));
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {

					switch (c) {
					case ')':
						if (stack.peek() == '(') {
							stack.pop();
						} else {
							return false;
						}
						break;
					case '}':
						if (stack.peek() == '{') {
							stack.pop();
						} else {
							return false;
						}
						break;
					case ']':
						if (stack.peek() == '[') {
							stack.pop();
						} else {
							return false;
						}
						break;
					}
				}

			}

		}
		return (stack.size() > 0) ? false : true;
	}

}