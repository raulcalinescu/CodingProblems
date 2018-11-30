package strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
Sherlock considers a string to be valid if all characters of the string appear the same number of times.
It is also valid if he can remove just character at index in the string, and the remaining characters will occur the
same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.
 */

public class ValidIfSameCountCharacters {

    // Complete the isValid function below.
    static String isValid(String s) {
        int cnt = 0;
        boolean firsTime = true, valid = true;
        Collection<Integer> values;
        Map chars = new HashMap<String, Integer>();  // need a hash map to store each character and its frequency
        int temp = 0;

        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++)
            if (chars.containsKey(c[i]))
                chars.put(c[i], (int) chars.get(c[i]) + 1);   // if we already have a character increase its freq
            else
                chars.put(c[i], 1);     // else add the new character to the map with a value of 1 for first occurrence

        values = chars.values();    // get the values only from the map
        Integer[] targetArray = values.toArray(new Integer[values.size()]);  // convert to array of integer objects

        for (Integer i : targetArray) {
            if (i == targetArray[0]) {    // store first element
                cnt = targetArray[0];
                continue;
            }

            if (i == cnt) continue;     // if the count is the same as the first one loop to next element
            else if (i == 1 && firsTime) {  // mark first 1 occurrence so we can invalidate on second 1 or different frequency
                firsTime = false;
                continue;
            }
            else if (i == cnt+1 && firsTime) { // mark first 'higher by one' count so we can invalidate if a different count is found
                firsTime = false;
                continue;
            }
            else {              // if it's different than the main cnt, or a second 1 occurrence or a second cn+1, invalidate
                valid = false;
                break;
            }
        }
        return valid ? "YES" : "NO";
    }




    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println(result);

        scanner.close();
    }
}
