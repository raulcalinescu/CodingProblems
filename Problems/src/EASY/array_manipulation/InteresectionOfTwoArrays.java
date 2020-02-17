package EASY.array_manipulation;

import java.util.HashSet;

/*
Given two arrays, write a function to compute their intersection.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]


 */
public class InteresectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1)
            set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2)
            set2.add(n);

        set1.retainAll(set2);   // the built in set intersection

        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1)
            output[idx++] = s;
        return output;
    }


    /*
    The naive approach would be to iterate along the first array nums1 and to check for each value if this value in nums2 or not.
    If yes - add the value to output. Such an approach would result in a pretty bad O(n×m) time complexity, where n and m are arrays' lengths.

To solve the problem in linear time, let's use the structure set, which provides in/contains operation in O(1) time in average case.
     */
    public static int[] intersection1(int[] nums1, int[] nums2) {
        int[] res = new int[(nums1.length > nums2.length)?nums2.length:nums1.length];
        int count = 0;
        if(nums1.length > nums2.length) {           // for worst case scenarios, query on the smallest array to save time
            for(int i=0; i<nums2.length; i++)
                for(int j=0; j<nums1.length; j++)
                    if(nums1[j]==nums2[i] && notFound(nums2[i],res)) {
                        res[count] = nums2[i];      // add the intersections into a new array size of smallest of the two
                        count++;
                        break;
                    }
        } else {
            for(int i=0; i<nums1.length; i++)
                for(int j=0; j<nums2.length; j++)
                    if(nums2[j]==nums1[i] && notFound(nums1[i],res)) {
                        res[count] = nums1[i];
                        count++;
                        break;
                    }

        }
        if(count < res.length) {
            int[] result = new int[count];
            for(int i=0; i<count; i++)
                result[i] = res[i];
            return result;
        } else
            return res;
    }

    public static boolean notFound(int value, int[] res) {
        for (int i = 0; i < res.length; i++) {
            if (value == res[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1,2,3,4,0};
        int[] a2 = new int[]{0,2,2,4};
        int[] res  = intersection(a1,a2);
        for(int i = 0; i<res.length; i++)
            System.out.print(res[i] + " ");
    }

}
