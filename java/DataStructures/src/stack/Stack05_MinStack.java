package stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * <pre>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * </pre>
 *
 * @author Gustavo
 */

public class Stack05_MinStack {
	
	
	Node head;
	
	private void push(int x) {
		if(head == null) {
			head = new Node(x, x, null);
		}else {
			Node new_head = new Node(x, Math.min(x, head.min)  , head);
			head = new_head;
		}
	}
	
	private void pop() {
		head = head.next;
	}

	private int top() {
		return head.val;
	}
	private int getMin() {
		return head.min;
	}
	

	class Node {
		int val;
		int min;
		Node next;
		Node(int val, int min, Node next) {
			this.val = val;
			this.min = min;
			this.next = next;
		}
	}	
}
