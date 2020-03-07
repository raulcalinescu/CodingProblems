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

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    }

    public static void main(String[] args) {
        ListNode test1 = new ListNode(1);
        test1.next = new ListNode(2);
        test1.next.next = new ListNode(4);

        ListNode test2 = new ListNode(1);
        test2.next = new ListNode(3);
        test2.next.next = new ListNode(4);

        ListNode result = mergeTwoLists(test1, test2);

        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
