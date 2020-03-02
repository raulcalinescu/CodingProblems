package EASY.string_manipulation;
/*
Write a function to find the longest common prefix string amongst an array of strings.

        If there is no common prefix, return an empty string "".

        Example 1:

        Input: ["flower","flow","flight"]
        Output: "fl"
        Example 2:

        Input: ["dog","racecar","car"]
        Output: ""
        Explanation: There is no common prefix among the input strings.
*/


public class longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            System.out.println(strs[i].indexOf(prefix));
            while (strs[i].indexOf(prefix) != 0) {    // returns 0 if matches, or -1 if not
                System.out.println(strs[i].indexOf(prefix));
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    //vertical scanning - less space complexity so more optimal than my solution
    public static String longestCommonPrefixVert(String[] strs) {
        if(strs.length == 0)
            return "";

        for(int i=0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(int j=1; j < strs.length; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0,i);
            }
        }
        return strs[0];
    }

    //vertical scanning - more optimal than horizontal since we limit the scanning from the beginning
    public static String longestCommonPrefixMySol(String[] strs) {
        if(strs.length == 0)
            return "";
        char[] first = strs[0].toCharArray();
        StringBuilder commonPrefix = new StringBuilder();
        int count = 0, min_length = first.length;

        for (String s : strs)                   // when strings are of different length watch for index out of bounds.
            if(s.length() < min_length)             //solve this by setting a minimum size
                min_length = s.length();

        for(int c = 0; c < min_length; c++) {       // for each character up to the minimum size of a string
            for (String s : strs) {             // check for a match in the other strings
                char[] temp = s.toCharArray();
                if (first[c] == temp[c])
                    count++;
            }
            if (count == strs.length) {     // if all strings matched the first string's character we add it to the prefix
                commonPrefix.append(first[c]);
                count = 0;
                continue;
            } else{                     // you only care about the first matching characters so as soon as we found one
              return commonPrefix.toString();                   //that does not have it we return.
            }
        }

        return commonPrefix.toString();
    }

    // time complexity is O(S) where S is the sum of all characters in the array of strings.
    // space complexity is O(1) because we only used constant EXTRA space.

    public static void main(String[] args) {
        String[] strs = {"hello","hellob","hellknger"};
    System.out.println(longestCommonPrefix(strs));
    }
}
