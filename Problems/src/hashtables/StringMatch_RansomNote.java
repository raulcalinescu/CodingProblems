package hashtables;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
Harold is a kidnapper who wrote a ransom note, but now he is worried it will be traced back to him through his handwriting.
He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable replica
of his ransom note. The words in his note are case-sensitive and he must use only whole words available in the magazine.
He cannot use substrings or concatenation to create the words he needs.

Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom note exactly
using whole words from the magazine; otherwise, print No.

For example, the note is "Attack at dawn". The magazine contains only "attack at dawn". The magazine has all the right words,
but there's a case mismatch. The answer is No
.
* */

public class StringMatch_RansomNote {

    public static int count = 0;
    public static final int ARR_SIZE = 30000;   // contraint to have a magazine/note with at most 30000 words.
    static LinkedList<String>[] arr = new LinkedList[ARR_SIZE];
    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        for (String word : magazine) {              // add the magazine words to the dictionary
            addToHT(word);
        }

        for (String word : note) {                      // check if the words in the note have a match in the magazine
            if(getStringAndRemove(word)) {
                count++;
            }
        }

        if (count == note.length)                 // each word matched gets a count increase, if all matched -> Yes
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    public static void addToHT(String s) {
        int index = Math.abs(s.hashCode() % ARR_SIZE);  // get an index based on the string/hashcode conversion function
        LinkedList<String> items = arr[index];          // create a separate linkedlist from the linked list present at
                                                                    // index found for that word
        if (items == null) {
            items = new LinkedList<String>();                   // if there is no LL at that index,
            items.add(s);                                           //create one and add the new word
            arr[index] = items;
        } else {                                        // else just add the new item to the linkedlist and
            items.add(s);                                       //assign it to the LL present at the corresponding index
            arr[index] = items;
        }
    }

    public static boolean getStringAndRemove(String s) {
        if (s == null)
            return false;

        int index = Math.abs(s.hashCode() % ARR_SIZE);     // get the corresponding index in the array of linked lists
        LinkedList<String> items = arr[index];     // assign that LL to a new LL

        if (items == null)
            return false;

        for (String item : items) {                     // if there is a match, remove it and return found.
            if (item.equals(s))
                items.remove(item);
                return true;
        }

        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}

