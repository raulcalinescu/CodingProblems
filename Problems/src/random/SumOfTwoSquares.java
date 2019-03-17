package random;

import java.util.Scanner;
import java.lang.Math;

/*
int n >= 0

n = a^2 + b^2;

if such a and b,
return true
else
return false
 */

public class SumOfTwoSquares {

    public static boolean areThereTwoSquaresSumFor (int n) {
        if (n < 0) {
            return false;
        }
                                                    // use pointers to traverse the possible squares in range
        int left = 0, right = (int) Math.sqrt(n);   // select left to be 0 and right the square root of number

        while (left <= right) {
            int current = left * left + right * right;   // test for the extremes and go inwards until match

            if (current < n) {
                left++;
            } else if (current > n) {
                right--;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        System.out.println(areThereTwoSquaresSumFor(n));
    }
}
