package linked_list;

/**
 * Given a ‘key’, delete the first occurrence of this key in the linked list.
 */
public class Linked05_DeleteNode {

    /**
     * Iterative Method:
     * To delete a node from the linked list, we need to do the following steps.
     * 1) Find the previous node of the node to be deleted.
     * 2) Change the next of the previous node.
     * 3) Free memory for the node to be deleted
     */

    public static void main(String[] args) {
        Linked05_DeleteNode app = new Linked05_DeleteNode();

        MyLinkedList ll = new MyLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        ll.head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(ll);
        //app.deleteNodeByKey( ll, 3);
        app.deleteNodeByPosition(ll, 10);
        System.out.println(ll);

    }

    public void deleteNodeByKey(MyLinkedList ll, int key){

        //finding the node with the value
        Node node = ll.head, prevNode = null;
        do {
            if (node.data == key)
                break;
            prevNode = node;  // What happen if not found, prevNode will be last one, wrong.
            node = node.next;
        }while(node!=null);

        //change the prev one pointer to 2 next nodes.
        prevNode.next = node.next;

        //free memory
        node = null;
    }

    public void deleteNodeByPosition(MyLinkedList ll, int position){

        if(ll.head ==null) {
            System.out.println("Head -> null");
            return;
        }

        Node node = ll.head, prevNode =null;

        //if head needs to be removed ( position ==0 )
        if(position == 0){
            ll.head = node.next;
            System.out.println("Head removed");
            return;
        }

        for (int i = 0; node!=null && i < position; i++) {
            prevNode = node;
            node = node.next;
        }

        if(node == null){
            System.out.println("node null, may mean that position is greater than size of linked list "+ position);
            return;
        }

        prevNode.next = node.next;
        node = null;

    }

}
