package EASY.arithmetic_algorithms;

import java.util.Stack;

public class Palindrome_Integer {

    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int palindrome = 0, temp = x;
        while (temp > 0) {
            palindrome = palindrome * 10 + temp % 10;   // no need to use stack because that puts it in the same order
            temp /= 10;                                 // just reversing the number is sufficient.
        }
        return palindrome == x;
    }


    public static boolean isPalindrome1(int x) {
        if(x < 0)
            return false;

        Stack n = new Stack();
        int temp = x;
        while(temp > 0) {
            int last_digit = temp % 10;
            n.push(last_digit);
            temp /= 10;
        }

        int palindrome = 0;
        while(!n.empty()) {
            palindrome = palindrome * 10 + (int) n.pop();   // this does not work when a number ends in 0
        }
        if(palindrome == x)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
