package DATA_STRUCTURES.Hierarchical.Binary_tree;


/*
Function Description
It must return the height of a binary tree as an integer.

DEF: The height of a binary tree is the largest number of edges in a path from the root node to a leaf node.

Note -> The Height of binary tree with single node is taken as zero.

Note: NodeIsBST values are inserted into a binary search tree before a reference to
the tree's root node is passed to your function.

In a binary search tree, all nodes on the left branch of a node are less than
the node value. All values on the right branch are greater than the node value.
 */

import java.util.*;

class HeightOfTree {

    /*
    class NodeIsBST
        int data;
        NodeIsBST left;
        NodeIsBST right;
    */

    public static int height(Node root) {
        // Write your code here.

        if(root == null) {
            return -1;
        } else {
            return 1 + (height(root.left)>height(root.right)?
                    height(root.left):height(root.right));
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = Node.insert(root,data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}

