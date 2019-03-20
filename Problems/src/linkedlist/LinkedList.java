package linkedlist;

public class LinkedList {
    Node head;

    // Linked list Node.
    // This inner class is made static
    // so that main() can access it
    static class Node {
        int data;
        Node next;

        // Constructor
        Node(int d) {
            data = d;
            next = null;
        }
    }

        public LinkedList insert(LinkedList list, int data) {

            if (list.head == null) {
                Node new_Node = new Node(data);
                list.head = new_Node;
                list.head.next = null;   // the newNode's next was already
                // null but keep this in mind
            } else {
                Node traverseNode = list.head;
                while (traverseNode.next != null) {  // traverse LL until last node
                    traverseNode = traverseNode.next;
                }
                Node new_Node = new Node(data);
                traverseNode.next = new_Node;

            }
            // Return the list by head
            return list;
        }

    }