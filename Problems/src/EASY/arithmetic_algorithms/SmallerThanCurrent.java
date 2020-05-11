package EASY.arithmetic_algorithms;
/*
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
Return the answer in an array.

Example 1:
Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

Example 2:
Input: nums = [6,5,4,8]
Output: [2,1,0,3]

Example 3:
Input: nums = [7,7,7,7]
Output: [0,0,0,0]
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallerThanCurrent {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] sorted = Arrays.copyOf(nums,nums.length);             // using a new sorted array to have smaller numbers indexed
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();                // storing the count of smallest numbers for each in Hashmap
        for(int i=0; i<sorted.length; i++) {
            map.put(sorted[i],i);
            while(i+1 < sorted.length && sorted[i+1] == sorted[i])  // only add the non repeating numbers, since their less
                i++;                                                // count will remain the same.
        }
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            ans[i] = map.get(nums[i]);                              // for each initial number, add its higher-then values
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,5,3,1,4,4,0};
        int[] ans = smallerNumbersThanCurrent(nums);
        for(int i : ans)
            System.out.print(i + " ");
    }
}
