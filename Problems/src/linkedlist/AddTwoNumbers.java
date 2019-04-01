package linkedlist;

import java.util.*;

public class AddTwoNumbers {

    public static StringBuilder sumOfTwo (LinkedList l1, LinkedList l2) {
        int count, count1 = 0, count2 = 0;
        // Creating an empty Stack
        Stack<Integer> STACK1 = new Stack<Integer>();
        Stack<Integer> STACK2 = new Stack<Integer>();
        Stack<Integer> Sum = new Stack<Integer>();

        while (l1.head != null) {
            STACK1.push(l1.head.data);
            l1.head = l1.head.next;
            count1++;
        }

        while (l2.head != null) {
            STACK2.push(l2.head.data);
            l2.head = l2.head.next;
            count2++;
        }
        int carry = 0, digit;

        count = (count1>=count2)? count1 : count2;

        while (count2 > 0 || count1 > 0) {
            digit = STACK1.pop() + STACK2.pop() + carry;
            if(digit > 9)  {
                Sum.push(digit - 10);
                carry = 1;
                count2--;
                count1--;
            } else {
                Sum.push(digit);
                carry = 0;
                count2--;
                count1--;
            }
        }

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(Sum.pop());
        }

        return s;
    }

    public static void main(String Args[]) {
        Scanner sc = new Scanner (System.in);
        Scanner scanLL = new Scanner (System.in);


        LinkedList l1 = new LinkedList();
        //l1.head = null;
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            l1.insert(l1,scanLL.nextInt());
        }

        LinkedList l2 = new LinkedList();
        //l2.head = null;

        for (int i = 0; i < n; i++) {
            l2.insert(l2,scanLL.nextInt());
        }

        System.out.println(sumOfTwo(l1,l2));
    }

}
