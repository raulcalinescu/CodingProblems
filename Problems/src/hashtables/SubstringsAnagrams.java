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
/*
    public static final int ARR_SIZE = 100;
    public static LinkedList<HTObject>[] arr = new LinkedList[ARR_SIZE];
    public static Set<String> uniqueChars = new HashSet();


    public static class HTObject {
        public String key;
        public Integer value;
    }
*/
    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    /*    for (char c : s.toCharArray()) {
            addToHT(String.valueOf(c),index_value);
            index_value++;
        }

        for (char c : s.toCharArray()) {                            // approach with the HT
            if (!uniqueChars.contains(String.valueOf(c))) {
                pairs += getCharacterFrequencyBasedPairs(String.valueOf(c));
                uniqueChars.add(String.valueOf(c));
            }
        } */
        char[] sChar = s.toCharArray();
        boolean hitBreak = false;
        int pairs = 0;
        StringBuilder s1_b = new StringBuilder(), s2_b = new StringBuilder();

        for (int index = 0; index < sChar.length - 1; index++) {
            for (int i = index; i < sChar.length - 1; i++) {
                s1_b.append(sChar[i]);

                    for (int k = index + 1; k < sChar.length; k++) {
                            s2_b.append(sChar[k]);

                        for (int j = k + 1; (s2_b.length() < s1_b.length()); j++) {
                            if (j <= sChar.length - 1) {
                                s2_b.append(sChar[j]);
                            } else {
                                hitBreak = true;
                                break;
                            }
                        }

                        if (hitBreak){
                            hitBreak = false;
                            s2_b = new StringBuilder();
                            break;
                        }

                        if (anagrams(s1_b.toString(), s2_b.toString()))
                            pairs++;

                        s2_b = new StringBuilder();
                    }
            }
            s1_b = new StringBuilder();
        }
        return pairs;
    }

    public static boolean anagrams(String a, String b) {
        char[] arr = a.toCharArray(), brr = b.toCharArray();
        boolean iFound = false;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < brr.length; j++) {
                if (arr[i] == brr[j]) {
                    brr[j] = ' ';
                    iFound = true;
                    break;
                }
            }
            if (!iFound)
                return false;
            iFound = false;
        }
        return true;
    }

    /*
    public static void addToHT(String s, Integer index_value) {
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

    public static HTObject getFromHT(String s) {
        if(s == null)
            return null;

        int index = Math.abs(s.hashCode() % ARR_SIZE);
        LinkedList<HTObject> items = arr[index];

        if (items == null)
            return null;

        for (HTObject item : items) {
            if (item.key.equals(s))
                return item;
        }
        return null;

    }

    public static int getCharacterFrequencyBasedPairs(String s) {
        int index = Math.abs(s.hashCode() % ARR_SIZE), count = 0;
        LinkedList<HTObject> items = arr[index];

        for (HTObject item : items)
            if (item.key.equals(s))
                count++;

        return (count*(count-1))/2;
    }
*/


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
