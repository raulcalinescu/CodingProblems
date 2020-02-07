package DATA_STRUCTURES.Strings;

import java.util.HashSet;
import java.util.Set;

/*
You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive,
so "a" is considered a different type of stone from "A".

Example 1:
Input: J = "aA", S = "aAAbbbb"
Output: 3

Example 2:
Input: J = "z", S = "ZZ"
Output: 0

Note:
S and J will consist of letters and have length at most 50.
The characters in J are distinct.
 */

public class JewelsAndStones {
    public static int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> hash_set = new HashSet<Character>();   // time complexity -> O(n), space O(sj)
        for(char c : J.toCharArray()) {
            hash_set.add(c);
        }

        for(char c : S.toCharArray()) {
            if(hash_set.contains(c)) {     // each search is O(1) so the loop is O(n)
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = numJewelsInStones("aA", "FrtadsAA");
        System.out.println(count);
    }
}
