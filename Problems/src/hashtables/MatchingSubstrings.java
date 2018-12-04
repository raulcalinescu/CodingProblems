package hashtables;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*

Given two strings, determine if they share a common substring. A substring may be as small as one character.

For example, the words "a", "and", "art" share the common substring
. The words "be" and "cat" do not share a substring.

Complete the function twoStrings in the editor below. It should return a string, either YES or NO based on whether the
strings share a common substring.
 */

public class MatchingSubstrings {

    // Complete the twoStrings function below.

    public static final int ARR_SIZE = 100000;
    static LinkedList<String>[] arr = new LinkedList[ARR_SIZE];

    static String twoStrings(String s1, String s2) {
        for (char c : s1.toCharArray()) {
            addToHT(c);
        }

        for (char c : s2.toCharArray()) {
            if(stringPresent(c)) {
                arr = new LinkedList[ARR_SIZE];
                return "YES";
            }
        }
        arr = new LinkedList[ARR_SIZE];
        return "NO";

    }

    public static void addToHT(char c) {
        int index = Math.abs (Character.toString(c).hashCode() % ARR_SIZE);
        LinkedList<String> items = arr[index];

        if (items == null) {
            items = new LinkedList<String>();
            items.add(Character.toString(c));
            arr[index] = items;
        } else {
            items.add(Character.toString(c));
            arr[index] = items;
        }
    }

    public static boolean stringPresent(char c) {
        if (Character.toString(c) == null) return false;
        int index = Math.abs (Character.toString(c).hashCode() % ARR_SIZE);
        LinkedList<String> items = arr[index];

        if (items == null)
            return false;

        for (String item : items) {
            if (item.equals(Character.toString(c)))
                return true;
        }
        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
        }



        scanner.close();
    }
}

