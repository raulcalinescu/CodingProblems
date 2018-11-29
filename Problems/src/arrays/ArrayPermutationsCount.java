package arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayPermutationsCount {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        boolean isSorted = false, tooChaotic = false;
        int temp, lastUnsorted = q.length - 1;
        int[] bribes = new int[q.length + 1];
        /* Each class variable, instance variable, or array component is initialized with a default value when
        it is created. For type int, the default value is zero, that is, 0. */

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < lastUnsorted; i++) {
                if (q[i] > q[i+1]) {
                    temp = q[i];
                    q[i] = q[i+1];
                    q[i+1] = temp;
                    isSorted = false;
                    /* add bribe here for q[i] */

                    bribes[q[i]]++;
                    if (bribes[q[i]] > 2) {
                        tooChaotic = true;
                        break;
                    }
                }
            }
            if (tooChaotic) break;
            lastUnsorted--;

        }
        if(tooChaotic)
            System.out.println();
        else {
            for (int i = 1; i < bribes.length; i++)
                bribes[0] = bribes[0] + bribes[i];
            System.out.println(bribes[0]);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
