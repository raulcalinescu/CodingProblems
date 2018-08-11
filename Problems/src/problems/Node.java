package problems;

public class Node {
    int data;
    Node left;
    Node right;
    public Node (int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
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

    boolean checkBST(Node root) {
     return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean check(Node n, int min, int max) {
        if (n == null)
            return true;
        if (n.data <= min || n.data >= max)
            return false;
        else
            return check(n.left, min, n.data) && check(n.right, n.data, max);
    }


}
