package algorithms;

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


    public static char[] findMaxRec(char[] c) {
        String subs, temp = new String();

        if (longestWord.isWord(String.valueOf(c)))
            return c;
        else {
            for (int i = 0; i < c.length; i++) {
                subs = String.valueOf(c).substring(0, i) + String.valueOf(c).substring(i + 1);
               if (longestWord.isWord(subs))
                   return subs.toCharArray();
               if (i > 0)
                   temp = temp + String.valueOf(c[i]);
            }
            return findMaxRec(temp.toCharArray());
        }
    }

    public static boolean isWord(String w) {   // brute force Dictionary dummy function for testing purposes
        if(w.equals("on") | w.equals("nut")) // | w.equals("day") | w.equals("on") | w.equals("lemonade"))
            return true;
        else
            return false;
    }

    public static void main (String[] Args) {
        String result = new String();
        Scanner sc = new Scanner(System.in);
        char[] a = sc.next().toCharArray();
        System.out.println(longestWord.findMaxRec(a));

        }
    }


