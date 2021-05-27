package linked_list;

public class MyLinkedList {
    Node head;

    @Override
    public String toString() {

        if(head ==null){
            return "Head -> null";
        }else{
            Node node = head;
            StringBuilder sb = new StringBuilder();
            while(node!=null){
                sb.append(node.data).append(" ");
                node = node.next;
            }
            return sb.toString();
        }
    }
}
