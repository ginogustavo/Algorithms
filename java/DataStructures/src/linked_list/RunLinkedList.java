package linked_list;

public class RunLinkedList {

	public static void main(String[] args) {
		Linked01_Basics linkedList = new Linked01_Basics(); // Initialize empty LinkedList
		linkedList.addAtHead(1);
		linkedList.printLL();
		
		linkedList.addAtTail(3);
		linkedList.printLL();
		
		linkedList.addAtIndex(1, 2); // linked list becomes 1->2->3
		linkedList.printLL();
		
		linkedList.get(1); // returns 2
		linkedList.printLL();
		
		linkedList.deleteAtIndex(1); // now the linked list is 1->3
		linkedList.printLL();
		
		linkedList.get(1); // returns 3
		linkedList.printLL();
	}
}
