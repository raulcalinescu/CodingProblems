package DATA_STRUCTURES.LinkedList;
import java.util.LinkedList;
import java.util.List;

/*
Given a linked list, remove the n-th node from the end of list and return its head.
        Example:
        Given linked list: 1->2->3->4->5, and n = 2.

        After removing the second node from the end, the linked list becomes 1->2->3->5.
        Note:
        Given n will always be valid.

        Example:
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

D->1->2->3->4->5
  3  2  1 hence we do 3 -> 5 at this step
Follow up:
        Could you do this in one pass?
 */

import java.util.LinkedHashMap;

public class removeNthNode {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    /*
        Thinking process:
        Since we'll have to return the head of the list after we modify its element, we should keep reference of the head
        with a dummy node to point to the head the whole time.

        Then we see from example that the nth node's location we need to remove is equal to Length - n + 1, so we need to
        find the Length first

        Then we traverse the LL again from dummy node to the nth node and re-assign the previous node's next pointer to the
        nth node's next pointer. (this is how we disconnect/remove nth node from the list)

        Finally, we return the dummy.next pointer (which is the old head).
     */
                // The TWO PASS Algorithm
    public static ListNode removeNthFromEndTwoPass(ListNode head, int n) {
        int length = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        while(first != null) {
            length++;
            first = first.next;
        }
        length = length - n;   // resize the length so when we traverse it again, we stop at the nth's prev node.
        first = dummy;
        while(length > 0) {  // first we go to the next elem then decrease length (example above -> 3 times)
            length--;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;   // dummy.next holds the head's address so we return that (1) to have LL 1->2->3->5
    }

    public static ListNode removeNthFromEndOnePass(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i=1; i<=n+1; i++)
            first = first.next;

        while(first != null) {
            first = first.next;
            second = second.next;
        }
        second = second.next.next;
        return dummy.next;  //or head
    }

    public static void main(String[] args) {

    }
}
