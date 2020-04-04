/*package EASY.string_manipulation;

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


import java.util.HashMap;
import java.util.Stack;

public class validParentheses {

    /*
    An interesting property about a valid parenthesis expression is that a sub-expression of
    a valid expression should also be a valid expression. (Not every sub-expression)
    What if whenever we encounter a matching pair of parenthesis in the expression,
    we simply remove it from the expression?

    The stack data structure can come in handy here in representing this recursive structure of the problem.
    We can't really process this from the inside out because we don't have an idea about the overall structure.
    But, the stack can help us process this recursively i.e. from outside to inwards.

    public HashMap<Character,Character> parenthesesMap;
    public validParentheses() {
        this.parenthesesMap = new HashMap<Character, Character>();
        this.parenthesesMap.put(')','(');
        this.parenthesesMap.put(']','[');
        this.parenthesesMap.put('}','{');
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(this.parenthesesMap.containsKey(c)) {  // if closing bracket
                char topOfStack = st.empty() ? '#' : st.pop();
                if (topOfStack != this.parenthesesMap.get(c))
                    return false;
            } else {
                   st.push(c);      // if open bracket
            }
        }
        return st.empty();
    }

    // O(n) time and O(n) space
    public static boolean isValid_MyUglySolution_faster1msthan99perc(String s) {  // works but timed out -- too long
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
*/
