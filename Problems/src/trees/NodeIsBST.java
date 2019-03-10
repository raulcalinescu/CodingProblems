package trees;

public class NodeIsBST {
    int data;
    NodeIsBST left;
    NodeIsBST right;

    public NodeIsBST(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new NodeIsBST(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new NodeIsBST(value);
            } else {
                right.insert(value);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(data);
        if (right != null) {
            right.printInOrder();
        }
    }

    boolean checkBST(NodeIsBST root) {

        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean check(NodeIsBST n, int min, int max) {
        if (n == null)
            return true;
        if (n.data <= min || n.data >= max)
            return false;
        else
            return check(n.left, min, n.data) && check(n.right, n.data, max);
    }

    public static boolean contains(int value) {

    }

    public static void main(String[] args) {

        NodeIsBST bst = new NodeIsBST(5);
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
