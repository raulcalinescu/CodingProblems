package EASY.string_manipulation;

/*
Balanced strings are those who have equal quantity of 'L' and 'R' characters.
Given a balanced string s split it in the maximum amount of balanced strings.
Return the maximum amount of splitted balanced strings.
Example 1:
Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.

Example 2:
Input: s = "RL LLLRRR LR"
Output: 3
Explanation: s can be split into "RL", "LLLRRR", "LR", each substring contains same number of 'L' and 'R'.

Example 3:
Input: s = "LLLLRRRR"
Output: 1
Explanation: s can be split into "LLLLRRRR".

Example 4:
Input: s = "RL RRRLLRLL"
Output: 2
Explanation: s can be split into "RL", "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'

 Constraints:
1 <= s.length <= 1000
s[i] = 'L' or 'R'

 */
public class BalancedStringSplit {
    public static int balancedStringSplit(String s) {
        char[] str = s.toCharArray();
        int R=0, L=0, cnt=0;
        for(int c = 0; c < str.length; c++) {
            if(str[c] == 'R') R++;
            else L++;
            if(L==R) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "LRRLRRLL";
        System.out.println(balancedStringSplit(s));
    }
}
