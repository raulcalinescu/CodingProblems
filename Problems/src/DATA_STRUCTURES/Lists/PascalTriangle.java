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
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> mainList = new ArrayList<List<Integer>>();
        List<Integer> prevList;
        for(int i=1; i<=numRows; i++) {
            List<Integer> rowList = new ArrayList<Integer>();
             for(int num=1; num<=i; num++) {
                if(num==1)
                    rowList.add(1);
                else if(num==i)
                    rowList.add(1);
                else rowList.add();

                prevList = rowList;
            }
            mainList.add(rowList);
        }
        return mainList;
    }

    public static void main(String[] args) {

    }
}
