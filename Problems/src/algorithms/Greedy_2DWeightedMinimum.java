package algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Greedy_2DWeightedMinimum {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int[] arr = new int[contests.length];
        int sum = 0, diff = 0;

        for (int i = 0, j= 0; i < contests.length; i++) {
            if (contests[i][1] == 1) {
                arr[j] = contests[i][0];
                j++;
            }
            sum += contests[i][0];
        }

        if (k == arr.length)
            return sum;

        else {
            Arrays.sort(arr);
            diff = arr.length - k;
            for(int i = 0; diff != 0; i++) {
                sum -= (2 * arr[i]);
                diff--;
            }
            return sum;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        System.out.println(result);

        scanner.close();
    }
}

