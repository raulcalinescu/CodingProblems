package algorithms;

public class IsBST {

    public static void main(String[] args) {

        Node bst = new Node(5);
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(8);
        bst.insert(7);
        bst.insert(12);
        bst.printInOrder();
        System.out.println(bst.checkBST(bst));
    }
}
