package recursion;

import java.util.*;

// given a number n, find the nth number in the fibonacci sequence
// f(0) = 0, f(1) = 1, and then f(n) = f(n-1) + f(n-2)

public class Fibonacci {

    public static int fibonacci(int n) {
        // Complete the function.
        if(n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci (n-2);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}