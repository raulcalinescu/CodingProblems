package linkedlist;

import java.util.Stack;

/*
Given head which is a reference node to a singly-linked list.
The value of each node in the linked list is either 0 or 1.
The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.
 */


public class LinkedListBinaryToInteger {
    public int getDecimalValue(Node head) {

        if(head == null)
            return 0;

        String number = new String();

        while(head!=null) {
            number = number + head.data;
            head = head.next;
        }

        return Integer.parseInt(number,2);  // This function parses the string argument as a signed
                                     // integer in the radix specified by the second argument.
    }

    //My solution:  -- did not work for all numbers
    /*public int getDecimalValue(Node head) {
        int integer = 0, converted = 0;
        while(head != null) {
            integer = integer * 10 + head.data;
            head = head.next;
        }

        for(int i = 0; integer != 0; i++) {
            converted = (int)Math.pow(2,i) * (integer % 10) + converted;
            integer /= 10;
        }

        return converted;
    }

    public static void main(String[] args) {
        int test = 9;
        test /= 10;
        System.out.println(test);
    }*/
}
