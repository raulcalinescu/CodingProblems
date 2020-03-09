package EASY.string_manipulation;

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
(Note that an empty string is also considered valid.)
Input: "()"
Output: true

Input: "()[]{}"
Output: true


Input: "{[]}"
Output: true

Input: "(]"
Output: false

Input: "([)]"
Output: false

    }

    ()()[{}]
 */

import java.util.Stack;

public class validParentheses {

    public static boolean isValid_MyUglySolution(String s) {  // works but timed out -- too long
        if(s=="") return true;
        Stack<Character> st = new Stack();
        char[] c = s.toCharArray();
        int count = 0;
        for(int i=0; i < c.length; i++) {
            Character ch = c[i];
            switch(c[i]) {
                case '(':
                case '[':
                case '{':
                {st.push(ch); count++; continue;}
                case ')': {
                    count--;
                    if(count < 0) return false;
                    Character popC = st.pop();

                    if('(' == popC.charValue())
                        continue;
                    else
                        return false;
                }
                case ']': {
                    count--;
                    if(count < 0) return false;
                    Character popC = st.pop();

                    if('[' == popC.charValue())
                        continue;
                    else
                        return false;
                }
                case '}': {
                    count--;
                    if(count < 0) return false;
                    Character popC = st.pop();
                    if('{' == popC.charValue())
                        continue;
                    else
                        return false;
                }
                default: return false;
            }
        }
        return count == 0? true:false;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        String s1 = "([)]{}";
        String s2 = "";
        String s3 = "()()[[(())]]";
        String s4 = "()[";
        String s5 = "]";
        System.out.println(isValid(s));
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
    }

}
