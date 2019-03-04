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
        int min = 0;

        Arrays.sort(c);

        if (c.length % k == 0) {
            for (int i = 0; i < c.length; i++) {
                min = min + c[i];
            }
        } else {

        }

        return min;
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
