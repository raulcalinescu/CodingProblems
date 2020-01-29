package DATA_STRUCTURES.Binary_tree;

/*
Binary Tree Data Structure
A tree whose elements have at most 2 children is called a binary tree.

Since each element in a binary tree can have only 2 children,
we typically name them the left and right child.

Trees can be represented in two ways:
1) Dynamic Node Representation (Linked Representation).
2) Array Representation (Sequential Representation).

 */

public class BinaryTree_array {

// implementation of tree using array -- numbering starting from 0 to n-1.
    static int root = 0;
    static String[] str = new String[10];

    public void Root(String value) {
        str[root] = value;
    }

    public void setLeft(String value, int root) {
        int leftIndex = root * 2 + 1;

        if(str[root] == null) {
            System.out.printf("Can't set child at %d, no parent found \n", leftIndex);
        } else {
            str[leftIndex] = value;
        }
    }

    public void setRight(String value, int root) {
        int rightIndex = root * 2 + 2;

        if(str[root] == null) {
            System.out.printf("Can't set child at %d, no parent found \n", rightIndex);
        } else {
            str[rightIndex] = value;
        }
    }

    public void printTree() {
        for(int i=0; i<str.length; i++) {
            if(str[i] != null) {
                System.out.printf(" %s", str[i]);
            } else
                System.out.print(" - ");
        }
    }

    public static void main(String[] args) {
        BinaryTree_array tree = new BinaryTree_array();
        tree.Root("Petrisor");
        tree.setLeft("Calin",0);
        tree.setRight("Lucian", 0);
        tree.setLeft("Raul",1);
        tree.setLeft("Rebecca", 2);
        tree.printTree();
    }

}
