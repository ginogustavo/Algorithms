package stack;
import java.util.Stack;

public class Stack01_TwoStack_to_Queue {

	Stack<String> stack1 = new Stack<String>();
	Stack<String> stack2 = new Stack<String>();

	public static void main(String[] args) {
		Stack01_TwoStack_to_Queue newDataStructure = new Stack01_TwoStack_to_Queue();
		newDataStructure.push("a");
		newDataStructure.push("b");
		newDataStructure.push("c");
		newDataStructure.push("d");
		newDataStructure.push("e");
		newDataStructure.push("f");

		System.out.println(newDataStructure.peek());
		System.out.println(newDataStructure.pop());
		System.out.println(newDataStructure.pop());
		System.out.println(newDataStructure.pop());
		System.out.println(newDataStructure.pop());
	}

	public void push(String item) {

		// iterate over stack 1 and pop to push in stack 2
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}

		// add item to stack 1
		stack1.push(item);

		// iterate over stack 2 to pop and push back to stack 1
		while (!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}

		System.out.println("Queue: "+stack1+ " / Position of "+item+" -> "+stack1.search(item));
		
	}

	public String peek() {
		return stack1.peek();
	}

	public String pop() {
		return stack1.pop();
	}
}
