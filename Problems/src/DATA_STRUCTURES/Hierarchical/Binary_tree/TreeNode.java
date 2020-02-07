package DATA_STRUCTURES.Hierarchical.Binary_tree;

/*
        1. One reason to use trees might be because you want to store information that naturally forms a hierarchy.
        For example, the file system on a computer:

        2. Trees (with some ordering e.g., BST) provide moderate access/search (quicker than Linked List and slower than DATA_STRUCTURES.arrays).

        3. Trees provide moderate insertion/deletion (quicker than Arrays and slower than Unordered Linked Lists).

        4. Like Linked Lists and unlike Arrays, Trees don’t have an upper limit on number of nodes as nodes are linked using pointers.

 */

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int item) {
        val = item;
        left = right = null;
    }
}
