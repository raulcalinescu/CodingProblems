package dynamicprog;

import sun.misc.Perf;
import java.util.Scanner;

// print minimum number of perfect squares that add up to a given number

public class PerfectSquares {
    static int count = 0;

    static int perfectSquare(int n) {
        int[] c = new int[n];
        c[0] = 1;
        c[1] = 2;
        c[3] = 3;

        for (int i = 4; i <= n; i++) {

        }


    }


    public static void main(String args[]) {
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        int result = perfectSquare(n);
        System.out.print(result);
    }

}