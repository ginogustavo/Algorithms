package tree;

public class BinaryTree {

    //Root of Binary
    Node root;

    //Constructors
    public BinaryTree(){
        root = null;
    }
    public BinaryTree(int value){
        root = new Node(value);
    }

    public static void main(String[] args) {
        BinaryTree btree = new BinaryTree();

        //Creating the Root.
        btree.root = new Node(20);
        /*      20
        *      /  \
        *   null  null
        */


        //Assigning left and right children of root
        btree.root.left = new Node(30);
        btree.root.right = new Node(40);
        /*          20
         *       /      \
         *     30       40
         *    / \       / \
         * null null null null
         */

         btree.root.left.left = new Node(60);
        /*           20
         *        /      \
         *      30        40
         *      / \       / \
         *    60  null null null
         *    / \
         * null null
         */


        /*  2nd example of tree creation.
                 2
               /   \
              3     4
             / \
            5   6                */

        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node2.left = node3;
        node2.right = node4;
        node3.left = node5;
        node3.right = node6;


//        BinaryTree bt2 = new BinaryTree(1);
//        bt2.root.left = node2;


    }
}
