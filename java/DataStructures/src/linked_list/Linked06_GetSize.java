package linked_list;

/**
 * Recursive Solution
 */
public class Linked06_GetSize {

    public static void main(String[] args) {
        Linked06_GetSize app = new Linked06_GetSize();

        MyLinkedList ll = new MyLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(50);
        Node n6 = new Node(60);

        ll.head = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        int total = app.getCount(ll.head);
        System.out.println("total = " + total);
    }

    private int getCount(Node node){
        if(node == null)
            return 0;
        return 1+ getCount(node.next);
    }

}
