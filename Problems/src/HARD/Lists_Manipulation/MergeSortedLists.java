package HARD.Lists_Manipulation;
import java.util.*;

/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

 */

import DATA_STRUCTURES.LinkedList.LinkedList;

public class MergeSortedLists {

     // Definition for singly-linked list.
     private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
     }

    public ListNode mergeKLists(ListNode[] lists) {
         LinkedList result0 = new LinkedList();
         ListNode result = new ListNode(1);
        return result;
    }

    public static void main(String[] args) {

    }


}
