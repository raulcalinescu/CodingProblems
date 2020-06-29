package EASY.arithmetic_algorithms;
/*
Given an integer n, return any array containing n unique integers such that they add up to 0.
.
Example 1:
Input: n = 5
Output: [-7,-1,1,3,4]
Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
.
Example 2:
Input: n = 3
Output: [-1,0,1]
.
Example 3:
Input: n = 1
Output: [0]

Constraints:
1 <= n <= 1000
 */

import java.util.HashSet;
import java.util.Random;

/*   !!! NOTE
 Thought about generating random numbers to subtract their opposite and check with a
 hashset for duplicate, but turned out to be an unnecessary addition of data structures
 and steps since this can be solved with a simpler array traversal from 1,2,... n/2
 */

public class NUniqueIntegersSumUpToZero {
    public static int[] sumZero(int n) {
        int[] arr = new int[n];
        for(int i = 0; i < n-1; i++) {        // the simpler solution is the iteration itself
            if(i%2 == 0)
                arr[i] = i/2 + 1;           // for even locations
            else
                arr[i] = (i/2 + 1) * (-1);  // store the negative opposite on the odds
        }
        if(n%2!=0)      // since last element in the array may be different for odd
            arr[n-1] = 0;
        else
            arr[n-1] = -1*((n-1)/2 + 1) ;
        return arr;
    }

    public static void main(String[] args) {
        int[] a = sumZero(15);
        for(int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
    }
}
