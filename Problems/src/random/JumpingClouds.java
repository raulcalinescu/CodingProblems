package random;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*

Emma is playing a new mobile game that starts with consecutively numbered clouds.
Some of the clouds are thunderheads and others are cumulus. She can jump on any cumulus cloud having a number
that is equal to the number of the current cloud plus or . She must avoid the thunderheads.

Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud.
It is always possible to win the game.  0 1 0 0 0 1 0

For each game, Emma will get an array of clouds numbered if they are safe or if they must be avoided.
The number on each cloud is its index in the list so she must avoid the clouds at indexes and .
She could follow the following two paths: 0 - 2 - 4 - 6 or 0 - 2 - 3 - 4 - 6.
The first path takes 3 jumps while the second takes 4.
Minimum is 3 here.

 test 0 1 */

public class JumpingClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumps = 0, zeros = 0;

        for (int i = 0; i < c.length; i++) {
            if (c[i] == 0) {            // for each zero we increase the count
                zeros++;                // so we accumulate until we find a 1

            } else {
                    jumps = jumps + zeros / 2 + 1;      // when we have a 1, we add the jump
                    zeros = 0;                          // and we also add the number of jumps required over 0s which
            }                                           // equals to the floor approximation of [ (total 0s accumulated
                                                        // until a 1 is found) divided by 2 ]

            if (i == c.length - 1 && zeros != 0)        // consider case when we have more than one
                jumps = jumps + zeros / 2;              // zero after the last 1 in the array
        }
        return jumps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();

        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.print(c[i]);
        }

        int result = jumpingOnClouds(c);
        System.out.println("\n" + result);

        scanner.close();
    }
}

