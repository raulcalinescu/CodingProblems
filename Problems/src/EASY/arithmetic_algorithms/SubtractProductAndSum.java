package EASY.arithmetic_algorithms;
/*
Given an integer number n, return the difference between the product of its digits and the sum of its digits.
Example 1:
Input: n = 234
Output: 15
Explanation:
Product of digits = 2 * 3 * 4 = 24
Sum of digits = 2 + 3 + 4 = 9
Result = 24 - 9 = 15

Constraints:
1 <= n <= 10^5
 */
public class SubtractProductAndSum {

    public static int subtractProductAndSum(int n) {
        int sum = 0, prod = 1, digit;
        while(n > 0) {
            digit = n%10;
            sum = sum + digit;
            prod = prod * digit;
            n = n / 10;
        }
        return prod - sum;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }
}
