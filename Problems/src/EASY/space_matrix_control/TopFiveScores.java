package EASY.space_matrix_control;

/*
Given a list of scores of different students, return the average score of each student's top five scores in the order of each student's id.
Each entry items[i] has items[i][0] the student's id, and items[i][1] the student's score.  The average score is calculated using integer division.

Example 1:
Input: [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
Output: [[1,87],[2,88]]
Explanation:
The average of the student with id = 1 is 87.
The average of the student with id = 2 is 88.6. But with integer division their average converts to 88.
*/

import java.util.*;

public class TopFiveScores {
    public int[][] highFive(int[][] items) {             //store in a map with ID as the key
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();   // and value as ArrayList for scores
        for(int row=0; row<items.length; row++) {
                if(!map.containsKey(items[row][0]))             // if we haven't seen this ID yet, add an entry for it
                    map.put(items[row][0],new ArrayList());
                map.get(items[row][0]).add(items[row][1]);      // else we just add the score to the existing ID
        }



        return items;
    }

    public static void main(String[] args) {
        int[][] a = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        for(int row=0; row<a.length; row++) {
            for (int col = 0; col < a[0].length; col++)
                System.out.println(a[row][col] + " ");
            System.out.print("\n");
        }
    }

}
