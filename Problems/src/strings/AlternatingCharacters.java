package strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
You are given a string containing characters A and B only. Your task is to change it into a string such that there are
no matching adjacent characters.  To do this, you are allowed to delete zero or more characters in the string.

Your task is to find the minimum number of required deletions.
For example, given the string, s= AABAAB, remove an A at positions 0 and 3 to make s = ABAB in 2 deletions.

Function Description
Complete the alternatingCharacters function in the editor below. It must return an integer representing the minimum
number of deletions to make the alternating string.
 */

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        char[] c = s.toCharArray();
        int count = 0;
        int length = c.length;  //if array has 3 characters, length is 3 so it's making i go from 0 to 3
                                                                                // if no bounds are conditioned.

        for (int i = 0; i < c.length - 1; i++)          // avoid out of bounds error by traversing
            if (c[i] == c[i+1])                          // only to length - 1 when accesing c[i+1]
                count++;

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

           System.out.println(result);
        }
        scanner.close();
    }
}

