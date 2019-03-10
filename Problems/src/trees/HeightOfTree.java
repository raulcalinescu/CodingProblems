package trees;


/*
Function Description
It must return the height of a binary tree as an integer.

getHeight or height has the following parameter(s):

    root: a reference to the root of a binary tree.

Note -> The Height of binary tree with single node is taken as zero.

Note: NodeIsBST values are inserted into a binary search tree before a reference to
the tree's root node is passed to your function.

In a binary search tree, all nodes on the left branch of a node are less than
the node value. All values on the right branch are greater than the node value.
 */
import java.util.*;
import java.io.*;

class HeightOfTree {

    /*
    class NodeIsBST
        int data;
        NodeIsBST left;
        NodeIsBST right;
    */
    public static int height(Node root) {
        // Write your code here.
        int height = 0;

        return height;
    }



    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = trees.Node.insert(root,data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }
}

