package DATA_STRUCTURES.Hierarchical.Binary_tree;
/*

Main applications of trees include:
1. Manipulate hierarchical data.
2. Make information easy to search (see tree traversal).
3. Manipulate sorted lists of data.
4. As a workflow for compositing digital images for visual effects.
5. Router algorithms
6. Form of a multi-stage decision-making (see business chess).


Depth First Traversals:
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1

Breadth First or Level Order Traversal : 1 2 3 4 5

 */

public class BinaryTree_nodes {
    TreeNode root;

    BinaryTree_nodes(int data) {
        root = new TreeNode(data);
    }

    BinaryTree_nodes() {
        root = null;
    }

    void printBreathFirstTraversal() {   // level order traversal
        int h = height(root);
        for(int i=1; i<=h; i++) {
            traverseBreathFirst(root,i);
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
        // print nodes at the given level
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


    public static void main(String[] args) {
        BinaryTree_nodes BT = new BinaryTree_nodes();
        BT.root = new TreeNode(20);
        BT.root.left = new TreeNode(8);
        BT.root.right = new TreeNode(12);
        BT.root.left.left = new TreeNode(4);
        BT.root.left.right = new TreeNode(4);
        BT.root.right.left = new TreeNode(6);
        BT.root.right.right = new TreeNode(6);
        BT.printBreathFirstTraversal();
    }
}
