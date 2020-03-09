package EASY.LinkedLists_manipulation;

/*
        Merge two sorted linked lists and return it as a new list.
        The new list should be made by splicing together the nodes of the first two lists.

        Input: 1->2->4, 1->3->4
        Output: 1->1->2->3->4->4

 */

import java.util.List;

public class MergeTwoSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    // O(n + m) and space: O(1), only few extra pointers which are constant
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
            // keep track of head of the merged list with head, use curr to change pointers as we compare
        ListNode head = new ListNode(0);
        ListNode cur = head;
        head.next = l1;         // make sure you assign the next field to one of the lists or else while loop is always false
            // iterate until one of the two list reach the end
        while(cur.next != null)
            if(l1.val < l2.val) {
                cur.next = l1;  // move the curr to the next smallest element
                cur = l1;
                l1 = l1.next;   // increase the pointer for list 1
            } else {
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }

        if(l1 == null) cur.next = l2;   // if we ended l1, connect the merged lists to the remaining elements in l2
        else if(l2 == null) cur.next = l1;  // else, do the same on l1

        return head.next;   // return the head of the list from first smallest sorted element
    }
    // O(n+m) and space O(n+m) - each recursive call takes another stack frame.
    public static ListNode mergeTwoListsRec(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoListsRec(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsRec(l2.next, l1);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        test1.next = new ListNode(3);
        //test1.next.next = new ListNode(9);

        ListNode test2 = new ListNode(2);
        test2.next = new ListNode(4);
        //test2.next.next = new ListNode(4);

        ListNode result = mergeTwoListsRec(test1, test2);

        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
