package algorithms;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class Greedy_Florist_minPriceFirst {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        int minSum = 0;
        int count = 0, countBuyer = 0;                      // which round we are at for buyers
        int totalCount = c.length / k;      // keep track of rounds for each buyer
        int tempCount = totalCount;         // Count will decrease only when a new round; to indicate last round
        Arrays.sort(c);

        if (c.length % k == 0) {
            for (int i = c.length - 1, j = 0; i >= 0 && j < c.length; i--, j++) {  // traverse the array backwards to get the
                if (count < totalCount && tempCount >= 0) {
                    minSum = minSum + c[i] * (count + 1);                         // higher costs first for 0 multiplyer
                    countBuyer ++;
                } else {
                    tempCount--;
                    countBuyer = 0;
                    count++;
                    minSum = minSum + c[i] * (count + 1);
                }
            }
        }

        return minSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);
        System.out.print(minimumCost);

        scanner.close();
    }
}
