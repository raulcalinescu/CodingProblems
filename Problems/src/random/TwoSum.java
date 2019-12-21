package random;

import java.util.*;

/*
Given an array of integers, return indices of the two numbers such that they
add up to a specific target.

Assume each input would have exactly one solution and do not use same element twice.

[2, 7, 9, 15], t = 9

return [0,1]

9 - 2 = 7 -> [2,9,15]
9 - 7 - > [9,15] // don t cover the last non successful visited element

*/

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];   // creates a two element array.
        for(int i = 0; i<nums.length; i++) {
            for(int j= i+1; j<nums.length; j++) {
                if (target - nums[i] == nums[j]) {   // look for the two sum complement through remaining elems.
                    indices[0] = i;
                    indices[1] = j;
                }
            }

        }

        return indices;
    }

    /*  A BETTER SOLUTION TO SAVE A FEW EXTRA INSTRUCTIONS but still O(n^2)

    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                return new int[] { i, j };              <---- create the array on the return
            }
        }
    }
    throw new IllegalArgumentException("No two sum solution");   <---- protect if no return


    ---------------- Explanation -----------------
    For each element we try to find its complement through the rest of the array which takes O(n)
    time. Therefore time is O(n^2) and space is O(1).


     */

    public static void main(String[] args) {
        int[] a = {2,3,1};
        int[] indices = twoSum(a,3);
        for (int i=0; i<indices.length;i++) {
            System.out.print(indices[i] + " ");
        }
    }
}
