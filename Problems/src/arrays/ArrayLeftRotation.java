package arrays;

import java.util.*;

public class ArrayLeftRotation {


    public static void rotation (int[] a, int n, int d) {
        int count = 0;

        while (count < d) {
            int temp = a[0];

            for(int i = 0; i < n-1; i++) {
                a[i] = a[i+1];
            }
            a[n-1] = temp;
            count++;
        }
        for (int i = 0; i < n; i++)
            if (i != (n-1))
                System.out.print(a[i]+" ");
            else
                System.out.print(a[i]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        scanner.close();
        ArrayLeftRotation.rotation(a,n,k);
    }
}
