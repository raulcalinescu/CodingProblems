package strings;

import java.util.*;

/* Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings to be anagrams of
each other if the first string's letters can be rearranged to form the second string. In other words, both strings must
contain the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams, but bacdc and dcbad
are not.

Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of
character deletions required to make the two strings anagrams. Can you help her find this number?

Given two strings, a and b, that may or may not be of the same length, determine the minimum number of character deletions
required to make a and b anagrams. Any characters can be deleted from either of the strings. */

public class MakingAnagrams {

    public static void anagrams(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        StringBuilder temp = new StringBuilder();   // use String Builder to concatenate bunch of strings together.
        int countDiffAnagram = 0;

        for (int i = 0; i < aArr.length; i++)
            for (int j = 0; j < bArr.length; j++)
                if (aArr[i] == bArr[j]) {
                    temp.append(Character.toString(aArr[i]));   // add matches to stringbuilder
                    bArr[j] = ' ';          // empty matches so we don't count them again next time
                    break;
                }
        countDiffAnagram = a.length() + b.length() - 2*temp.length();   // total chars - char matches * 2strings
        System.out.println(countDiffAnagram);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String a = scanner.nextLine();

        String b = scanner.nextLine();

        scanner.close();
        MakingAnagrams.anagrams(a,b);
    }
}