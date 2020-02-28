package DATA_STRUCTURES.Lists;
import java.util.ArrayList;
import java.util.List;
/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> mainList = new ArrayList<List<Integer>>();
        List<Integer> nums1 = new ArrayList<Integer>();
        nums1.add(1);
        mainList.add(nums1);
        if(numRows == 1)
            return mainList;
        List<Integer> nums2 = new ArrayList<Integer>();
        nums2.add(1);
        nums2.add(1);
        mainList.add(nums2);
        if(numRows == 2)
            return mainList;

        for(int i=1; i<=numRows; i++) {

        }
        return mainList;
    }

    public static void main(String[] args) {
        System.out.println(generate(2));
    }
}
