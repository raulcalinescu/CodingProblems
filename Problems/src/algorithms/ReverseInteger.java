package algorithms;

/*
Given a 32-bit signed integer, reverse digits of an integer.

Note:
Assume we are dealing with an environment which could only store
integers within the 32-bit signed integer range: [−231,  231 − 1].
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

    public static int reverse(int num) {
        if (num > 231 || num < -231)
                return 0;

        int reverse = 0;
        for (int i = 0; num != 0; i++) {
            int temp = num % 10;
            reverse = reverse * 10 + temp;
            num = num / 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        int reverse = reverse(232);
        System.out.println(reverse);
    }


}



