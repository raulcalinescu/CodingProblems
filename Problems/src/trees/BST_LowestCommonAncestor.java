package trees;


import java.util.*;
import java.io.*;



public class BST_LowestCommonAncestor {

    public static Node lca(Node root, int v1, int v2) {
        if (root.data < v1 && root.data < v2) {
            return lca(root.right, v1, v2);
        } else if (root.data > v1 && root.data > v2) {
            return lca(root.left, v1, v2);
        } else {
            return root;
        }


    }

    /* performance improvementif you select which is bigger:

    node* lca_(node* root, int a, int b)
{
    if (b < root->data) {
        return lca_(root->left, a, b);
    }
    else if (a > root->data) {
        return lca_(root->right, a, b);
    }
    return root;
}

node* lca(node* root, int a, int b)
{
    if (a < b) {
        return lca_(root, a, b);
    }
    return lca_(root, b, a);
}

     */

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        int v1 = scan.nextInt();
        int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }
}
