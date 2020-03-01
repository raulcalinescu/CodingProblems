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

// be aware of many corner cases:
    // when strings are of different length watch for index out of bounds. solve this by setting a minimum size
    //
public class longestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        char[] first = strs[0].toCharArray();
        StringBuilder strB = new StringBuilder();
        int count = 0, min_length = first.length;

        for (String s : strs)
            if(s.length() < min_length)
                min_length = s.length();

        for(int c = 0; c < min_length; c++) {
            for (String s : strs) {
                char[] temp = s.toCharArray();
                if (first[c] == temp[c])
                    count++;
            }
            if (count == strs.length) {
                strB.append(first[c]);
                count = 0;
                continue;
            } else{
              return strB.toString();
            }
        }

        return strB.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"hello","hell","hellonger"};
    System.out.println(longestCommonPrefix(strs));
    }
}
