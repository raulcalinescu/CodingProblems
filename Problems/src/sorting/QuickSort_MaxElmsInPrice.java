package sorting;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class QuickSort_MaxElmsInPrice {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int sum = 0, count = 0;
        quicksort(prices,0,prices.length - 1);

        for (int i = 0; i < prices.length; i++) {
           if (sum+prices[i] <= k) {
               sum += prices[i];
               count++;
           }
        }
        return count;

    }

    static void quicksort (int[] arr, int left, int right) {    // l is the left most index and r is the right most index.
        if (left >= right) return;     // array of 1

        int pivot = arr[(left + right) / 2];      // value of the middle element of array
        int index = partition(arr, left, right, pivot);
        quicksort(arr, left, index -1);
        quicksort(arr, index, right);

    }

    static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) {
                left ++;
            }

            while (arr[right] > pivot) {
                right --;
            }

            if (left <= right) {
                swap (arr, left, right);
                left ++;
                right --;
            }
        }
        return left;
    }

    static void swap (int[] arr, int left, int right){
        int temp = 0;
        temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);
        System.out.print(result);
        scanner.close();
    }
}