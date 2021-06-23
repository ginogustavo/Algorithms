package tree;

public class Tree01_SumNodeValues {

    public static void main(String[] args) {
        Tree01_SumNodeValues app = new Tree01_SumNodeValues();
        app.calculateSum();
    }


    private void calculateSum() {
        BinaryTree tree = createTree();

        int total = sum(tree.root);

        System.out.println("Binary tree, total sum: " + total);
    }



    private BinaryTree createTree() {
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);

        BinaryTree btree = new BinaryTree();
        btree.root = root;
        return btree;

        //         2
        //       /   \
        //      3     4
        //     / \
        //    5   6
    }

    private int sum(Node node){
        if(node == null) return 0;
        return node.data  + sum(node.left) + sum(node.right);
    }
}
