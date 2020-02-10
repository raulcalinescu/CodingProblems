package DATA_STRUCTURES.Hierarchical.Binary_tree;

/*
Given a binary tree, find its maximum depth.

DEF: The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

[3,9,20,null,null,15,7]  -> 3

 */

import java.util.Scanner;

public class MaximumDepthBinaryTree {

    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        else
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        TreeNode root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = TreeNode.insert(root,data);
        }
        scan.close();
        int height = maxDepth(root);
        System.out.println(height);
    }
}
