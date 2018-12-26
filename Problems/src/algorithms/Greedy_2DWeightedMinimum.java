package algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/*
* Lena is preparing for an important coding competition that is preceded by a number of sequential preliminary contests.
* She believes in "saving luck", and wants to check her theory. Each contest is described by two integers, L[i] and T[i]


L [i] is the amount of luck associated with a contest. If Lena wins the contest, her luck balance will decrease by L[i];
 if she loses it, her luck balance will increase by L[i]
T [i] denotes the contest's importance rating. It's equal to 1 if the contest is important, and it's equal to 0 if it's
unimportant.

If Lena loses no more than k important contests, what is the maximum amount of luck she can have after competing in all
the preliminary contests? This value may be negative.

For example,
k = 2

and:

Contest		L[i]	T[i]
1		        5	1
2		        1	1
3		        4	0

If Lena loses all of the contests, her will be 5 + 1 + 4 = 10.
Since she is allowed to lose 2 important contests, and there are only 2 important contests. She can lose all three
contests to maximize her luck at 10. If k = 1, she has to win at least 1 of the 2 important contests.
She would choose to win the lowest value important contest worth 1 . Her final luck will be 5 + 4 - 1 = 8.
*
* */

public class Greedy_2DWeightedMinimum {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int[] arr = new int[contests.length];
        int sum = 0, diff = 0;

        for (int i = 0, j= 0; i < contests.length; i++) {
            if (contests[i][1] == 1) {
                arr[j] = contests[i][0];        // create an array of only important Lucks (weighted 1)
                j++;
            }
            sum += contests[i][0];              // summ of all the lucks
        }

        if (k == arr.length)                    // if number of weights 1 equal the number of allowed lost contests
            return sum;                         // we can summ all

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

