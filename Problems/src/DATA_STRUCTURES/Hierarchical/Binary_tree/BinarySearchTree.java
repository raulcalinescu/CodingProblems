package DATA_STRUCTURES.Hierarchical.Binary_tree;

/*
Binary Search Tree is a node-based binary tree data structure which has the following properties:

The left subtree of a node contains only nodes with keys lesser than the node’s key.
The right subtree of a node contains only nodes with keys greater than the node’s key.
The left and right subtree each must also be a binary search tree.

PB: 938. Range Sum of BST

Given the root node of a binary search tree, return the sum of values of all nodes with value
between L and R (inclusive).

The binary search tree is guaranteed to have unique values.
 */

import java.util.Stack;

public class BinarySearchTree {
    TreeNode root;

    BinarySearchTree(int data) {
        root = new TreeNode(data);
    }

    BinarySearchTree() {
        root = null;
    }

    void printBreathFirstTraversal() {   // level order traversal
        int h = height(root);
        for(int i=1; i<=h; i++) {
            traverseBreathFirst(root,i);
        }
    }
    public int rangeSumBST_iterative(TreeNode root, int L, int R) {   //using stack can act as recursion
        int ans = 0;
        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                if (L <= node.val && node.val <= R)
                    ans += node.val;
                if (L < node.val)
                    stack.push(node.left);
                if (node.val < R)
                    stack.push(node.right);
            }
        }
        return ans;
    }

    static int sum = 0;
    static int rangeSumBST(TreeNode node, int L, int R) {
        depthFirstSearch(node,L,R);
        return sum;
    }

    static void depthFirstSearch(TreeNode node, int L, int R) {
        if(node!=null) {
            if(node.val >= L && node.val <= R)
                sum+=node.val;
            if(node.val > L)
                depthFirstSearch(node.left,L,R);
            if(node.val < R)
                depthFirstSearch(node.right,L,R);
        }
    }

    void traverseBreathFirst(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height == 1) {
            System.out.print(root.val + " ");
        } else if (height >= 2) {
            traverseBreathFirst(root.left, height - 1);
            traverseBreathFirst(root.right, height - 1);
        }
    }

    int height(TreeNode root) {     // height of a tree is the number of nodes along the longest path from root to farthest leaf
        if(root == null) {
            return 0;
        } else {
            int left_height = height(root.left);       // get height of each subtree
            int right_height = height(root.right);

            if(left_height > right_height) {        // use the larger one
                return(left_height + 1);
            } else {
                return(right_height + 1);
            }

        }
    }

    public static void main(String[] args) {
        BinarySearchTree BST = new BinarySearchTree();
        BST.root = new TreeNode(10);
        BST.root.left = new TreeNode(5);
        BST.root.right = new TreeNode(15);
        BST.root.left.left = new TreeNode(3);
        BST.root.left.right = new TreeNode(7);
        BST.root.right.left = new TreeNode(13);
        BST.root.right.right = new TreeNode(18);
        BST.root.left.left.left = new TreeNode(1);
        BST.root.left.right.left = new TreeNode(6);
        BST.printBreathFirstTraversal();

        System.out.print(rangeSumBST(BST.root,6,10));
    }
}
