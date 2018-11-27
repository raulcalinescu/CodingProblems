package random;

/* Lilah has a string of lowercase English letters that she repeated infinitely many times.

Given an integer, find and print the number of letter a's in the first letters of Lilah's infinite string.*/

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;

public class RepeatedStringCharacterCount {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long count = 0;
        char[] charArray = s.toCharArray();

            for (char c : charArray)
                if (c == 'a')
                    count++;

            long factor = (n / s.length());   // take the repetitions of the entire string
            long rem = (n % s.length());        // take the number of characters in the last incomplete repetition (mod)
            count = factor * count;

            for (int i = 0; i < rem; i++)       // traverse the string one more time for the remaining characters
                if(s.charAt(i) == 'a')
                    count++;

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s = scanner.nextLine();

        long n = scanner.nextLong();

        long result = repeatedString(s, n);

        System.out.println(result);
        scanner.close();
    }
}