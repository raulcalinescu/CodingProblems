package hashtables;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/*
Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

For example 'mom', the list of all anagrammatic pairs is (m,m), (mo,om). So we have two pairs.

Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of
anagrammatic pairs of substrings in s.

2 <= s <= 100
* */

public class SubstringsAnagrams {

    public static int index_value = 0;
    public static final int ARR_SIZE = 100;
    public static LinkedList<HTObject>[] arr = new LinkedList[ARR_SIZE];

    public static class HTObject {
        public String key;
        public Integer value;
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        for (char c : s.toCharArray()) {
            arr[index] = c;
            index++;
        }

        return 0;
    }

    public void addToHT(String s, Integer index_value) {
        int index = Math.abs(s.hashCode() % ARR_SIZE);
        LinkedList<HTObject> items = arr[index];

        if(items == null) {
            items = new LinkedList<HTObject>();

            HTObject item = new HTObject();
            item.key = s;
            item.value = index_value;

            items.add(item);
            arr[index] = items;
        } else {
            HTObject item = new HTObject();
            item.key = s;
            item.value = index_value;

            items.add(item);
            arr[index] = items;
        }
    }



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(result);

        }

        scanner.close();
    }
}
