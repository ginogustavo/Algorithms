/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * <pre>
 * 	| A | B | -> | B | C | -> | C | A | //true
 *	| A | B | -> | B | C | -> | C | null | // false
 * </pre>
 * 
 * @author Gustavo
 *
 */
package linked_list;
public class ValidateCycle {
	// Two-pointer approach is more efficient than Hash table
	
	public static void main(String[] args) {
		new ValidateCycle().process();
	}
	private void process() {
		ListNode ln1 = new ListNode(1);
		ListNode ln2 = new ListNode(2);
		ListNode ln3 = new ListNode(3);
		ListNode ln4 = new ListNode(4);
		ListNode ln5 = new ListNode(5);
		
		ln1.next = ln2;
		ln2.next = ln3;
		ln3.next = ln4;
		ln4.next = ln5;
		ln5.next = ln1;
		
		
		System.out.println(hasCycle( ln1 ));
	}

	// Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		if (head.next == null)
			return false;
		
		ListNode current = head;
		ListNode node2 = current;
		
		while(current.next != null) {
			
			if(node2.next==null || node2.next.next==null) 
				return false;
			
			node2 = node2.next.next;
						
			if (current.val == node2.val) {
				return true;
			}
			current = current.next;
		}

		return false;
	}

}
