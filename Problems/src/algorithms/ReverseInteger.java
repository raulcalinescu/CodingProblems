package algorithms;

/*
Given a 32-bit signed integer, reverse digits of an integer.

Note:
Assume we are dealing with an environment which could only store
integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
For the purpose of this problem, assume that your function returns 0
when the reversed integer overflows.

[146]  -> [641]

input: num

for i = 0; num != 0; i++
    temp = num % 10
    reverse = reverse * 10 + temp;
    num = num / 10;
 */

public class ReverseInteger {

    public static int reverse(int x) {

        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;

        /* My first solution:

        int reverse = 0;
        for (int i = 0; num != 0; i++) {
            int temp = num % 10;
            reverse = reverse * 10 + temp;   // < --- this can cause overflow
            num = num / 10;
        }
        return reverse; */
    }

    public static void main(String[] args) {
        int reverse = reverse(-123);
        System.out.println(reverse);
    }


}



