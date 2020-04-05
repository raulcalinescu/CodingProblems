package DATA_STRUCTURES.Strings;

/*
Given a string S, remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.
Example 1:
Input: "leetcodeisacommunityforcoders"
Output: "ltcdscmmntyfrcdrs"

Example 2:
Input: "aeiou"
Output: ""

Note:
S consists of lowercase English letters only.   <<<<<
1 <= S.length <= 1000

 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveVowlsFromString {
    public static String removeVowels(String S) {

        S = S.replace("a","");
        S = S.replace("e","");
        S = S.replace("i","");
        S = S.replace("o","");
        S = S.replace("u","");

        return S;
    }

    public static String removeVowls(String S) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

        char[] charArray  = S.toCharArray();
        StringBuilder result = new StringBuilder();
        for(char ch: charArray){
            if(!vowels.contains(ch)){
                result.append(ch);
            }
        }
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        String s = "I am home";
        System.out.println(removeVowls(s));
    }
}
