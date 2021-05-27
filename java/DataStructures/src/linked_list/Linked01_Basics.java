/**
 * Design your implementation of the linked list. You can choose to use the singly
 *  linked list or the doubly linked list. A node in a singly linked list should have 
 *  two attributes: val and next. val is the value of the current node, and next is a 
 *  pointer/reference to the next node. If you want to use the doubly linked list, 
 *  you will need one more attribute prev to indicate the previous node in the linked 
 *  list. Assume all nodes in the linked list are 0-indexed.
 *  
 *  https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/
 */

package linked_list;

class Linked01_Basics {

	int size;
	Node head;

	class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Node: val : " + this.val;

		}
	}

	/** Initialize your data structure here. */
	public Linked01_Basics() {
		this.size = 0;
		this.head = null;
	}

	public void printLL() {
		Node node = this.head;
		System.out.println("\nSize: " + this.size);
		for (int i = 0; i < this.size; i++) {

			if (i != 0) {
				System.out.print("  ->  ");
			}

			String nextVal = (node.next == null) ? "NULL" : node.next.val + "";

			System.out.print("| " + node.val + " |" + nextVal + "|");
			node = node.next;
		}
		System.out.println("");

	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		if (index >= size || index < 0) {
			return -1;
		}
		if (index == 0) {
			return head.val;

		} else {

			Node nextNode = head;// .next;
			for (int i = 0; i < index; i++) {
				nextNode = nextNode.next;
			}
//			System.out.println(nextNode);
//			System.out.println("returning "+nextNode.val);
			return nextNode.val;
		}
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		Node newNode = new Node(val);
		newNode.next = this.head;
		this.head = newNode;
		this.size++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		if (this.size == 0) {
			addAtHead(val);
		} else {
			Node newNode = new Node(val);
			Node nextNode = this.head; // .next
			while (nextNode.next != null) {
				nextNode = nextNode.next;
			}
			nextNode.next = newNode;
			this.size++;
		}
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {

		if (index == 0) {
			addAtHead(val);
		} else if (index == this.size) {
			addAtTail(val);
		} else if (index < this.size) {
			Node newNode = new Node(val);
			Node prevNode = null;
			Node nextNode = this.head;
			for (int i = 0; i < index; i++) {
				if (i == index - 1) {
					prevNode = nextNode;
				}
				nextNode = nextNode.next;
			}
			newNode.next = nextNode;
			prevNode.next = newNode;//
			this.size++;
		}
	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (this.size >= 1) {

			if (index == 0) { // delete head
				Node tempHead = this.head;
				this.head = tempHead.next;
				// tempHead.next = null;
				// tempHead = null;
				this.size--;
			} else if (index < size) { // delete the specific index

				Node prevNode = null;
				Node nextNode = this.head;// .next;

				for (int i = 0; i <= index; i++) {
					if (i == index - 1) {
						prevNode = nextNode;
					}
					nextNode = nextNode.next;
				}
				prevNode.next = nextNode;// .next; //

				this.size--;
			}

		}
	}
}
