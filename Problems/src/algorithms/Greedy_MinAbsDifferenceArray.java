package algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/*
* Consider an array of integers. We define the absolute difference between two elements a[i], and a[j] (where i!=j ),
* to be the absolute value of | a[i] - a[j] |

Given an array of integers, find and print the minimum absolute difference between any two elements in the array.
* */

/*
* GREEDY ALGORITHM DEFINITION:
*
* always makes the choice that seems to be the best at that moment. This means that it makes a locally-optimal choice
* in the hope that this choice will lead to a globally-optimal solution.
*
* The Greedy algorithm has only one shot to compute the optimal solution so that it never goes back and reverses the
* decision.
*
* */

public class Greedy_MinAbsDifferenceArray {

    // Complete the minimumAbsoluteDifference function below.
    static int minimumAbsoluteDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);               // sort array first so you don't have to loop twice for each pair
                                        // in a sorted array, the minimum difference will be between consecutive nrs

        for (int i = 0; i < arr.length - 1; i++) {
            if (Math.abs(arr[i] - arr[i+1]) < min)
                min = Math.abs(arr[i] - arr[i+1]);
        }
        return min;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = minimumAbsoluteDifference(arr);

        System.out.println(result);

        scanner.close();
    }
}

