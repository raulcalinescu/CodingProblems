package problems;

import java.util.*;
import java.lang.*;

public class longestWord {

    public static char[] max = new char[]{'a'}; //{'a','s','d','e','3','d','h','g','t','y'};
    public static int k = 0;
    public static String word;

    public static char[] findMaxWord(char[] a) {
        for (int i = 0; i < a.length; i++) {
            k = i;
            word = String.valueOf(a[i]);

            while (k < a.length - 1) {
                for (int j = k+1; j < a.length; j++) {
                    word = word + String.valueOf(a[j]);
                    if ((longestWord.isWord(word)) && (word.length() > String.valueOf(max).length())) {
                        max = word.toCharArray();
                    }
                }
                k++;
                word = String.valueOf(a[i]);
            }
        }
        return max;
    }

    public static boolean isWord(String w) {   // brute force Dictionary dummy function for testing purposes
        if(w.equals("lemon") | w.equals("monday") | w.equals("day") | w.equals("on"))
            return true;
        else
            return false;
    }

    public static void main (String[] Args) {

        Scanner sc = new Scanner(System.in);
        char[] a = sc.next().toCharArray();
        System.out.println(longestWord.findMaxWord(a));

    }

}
