package arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/*
*
* It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! There are a number of people queued
* up, and each person wears a sticker indicating their initial position in the queue. Initial positions increment by
* from at the front of the line to at the back.

Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap positions,
they still wear the same sticker denoting their original places in line. One person can bribe at most two others.
For example, if n = 8,and Person 5 bribes Person 4, the queue will look like this: 1 2 3 [5 4] 6 7 8

Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue
 into its current state!

Function Description

Complete the function minimumBribes in the editor below. It must print an integer representing the minimum number of
bribes necessary, or Too chaotic if the line configuration is not possible.
*
* */

public class ArrayPermutationsCount {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        boolean isSorted = false, tooChaotic = false;
        int temp = 0, lastUnsorted = q.length - 1;
        int[] bribes = new int[q.length + 1];
        /* Each class variable, instance variable, or array component is initialized with a default value when
        it is created. For type int, the default value is zero, that is, 0. */

        while (!isSorted) {                                         // keep going until it's sorted
            isSorted = true;

            for (int i = 0; i < lastUnsorted; i++) {                // traverse until we reached the sorted max section
                if (q[i] > q[i+1]) {
                    temp = q[i];
                    q[i] = q[i+1];
                    q[i+1] = temp;
                    isSorted = false;                              // if we found a unsorted pair, we weren't sorted yet
                    /* add bribe here for q[i] */

                    bribes[temp]++;                               // count bribes for the corresponding person q[i]
                    if (bribes[temp] > 2) {                     // if a person bribed more than two times it is too Ch
                        tooChaotic = true;
                        break;
                    }
                }
            }
            if (tooChaotic) break;
            lastUnsorted--;                     // decrease the index for the unsorted element as we moved the max
                                            // to the end after a full loop and that is sorted so no need to loop again
        }
        if(tooChaotic)
            System.out.println("Too chaotic");
        else {
            for (int i = 1; i < bribes.length; i++)
                bribes[0]+= bribes[i];
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
