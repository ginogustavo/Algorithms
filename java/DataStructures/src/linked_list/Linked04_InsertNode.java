package linked_list;

public class Linked04_InsertNode {
    static Linked04_InsertNode globalLL;
    Node head;

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Linked04_InsertNode ll = new Linked04_InsertNode();
        ll.head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        ll.head.next = n2;
        n2.next = n3;
        globalLL = ll;

        ll.iterateLL();
        ll.addFront(new Node(10));
        ll.iterateLL();
        ll.addAfterGivenNode(n2,new Node(20));
        ll.iterateLL();
        ll.addEnd(new Node(50));
        ll.iterateLL();
    }

    public void iterateLL(){
        Node node = globalLL.head;
        do{
            System.out.print(node.data+" ");
            node = node.next;
        }while(node!=null);
        System.out.print("\n");
    }


    public void addFront(Node newNode){
        newNode.next = globalLL.head;
        globalLL.head = newNode;
    }
    public void addAfterGivenNode(Node prevNode, Node newNode){
         newNode.next = prevNode.next;
         prevNode.next = newNode;
    }
    public void addEnd(Node newNode){
        Node node = globalLL.head;

        do{
            node = node.next;
        }while(node.next != null);

        node.next = newNode;
    }
}
