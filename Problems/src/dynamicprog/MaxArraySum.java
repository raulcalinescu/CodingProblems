package dynamicprog;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import com.*;
import java.util.concurrent.*;
import java.util.regex.*;


// Memoization and dynamic programming
/*
Memoization - > store values at each layer of recursion instead of computing from scratch each time
  - linear run time instead of exponential (great improvement)



 */

public class MaxArraySum {

        static int maxSubsetSum(int[] arr) {
            if (arr.length == 0) {
                return 0;
            }
            arr[0] = Math.max(0, arr[0]);

            if (arr.length == 1) {
                return arr[0];
            }
            arr[1] = Math.max(arr[0], arr[1]);

            for (int i = 2; i < arr.length; i++) {
                arr[i] = Math.max(arr[i - 1], arr[i] + arr[i - 2]);
            }
            return arr[arr.length - 1];
        }


        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {


            int n = scanner.nextInt();


            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");


            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int res = maxSubsetSum(arr);
            System.out.println(res);

            scanner.close();
        }
    }

}
