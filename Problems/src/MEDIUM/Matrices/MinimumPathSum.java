package MEDIUM.Matrices;
/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum
of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[                   // use another matrix to store the sum as you advance through the original matrix
  [1,3,1],             [1,4,5]
  [1,5,1],    ->       [2,7,6]
  [4,2,1]              [6,8,7] -> (6+1) || (8+1) => answer is placed at the last entry summed up in 7.
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.

 */

public class MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        if (n == 0)
            return 0;
        int[][] dp = new int[n][m];
        //filling up the first row storing the sum of the path up to each element into that element's location
        dp[0][0] = grid[0][0];
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // //filling up the first column storing the sum of the path up to each element into that element's location
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            // filling up the rest of the row with the minimum between sum stored at the (upper location and left location)
            for (int j = 1; j < m; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        printMatrix(dp);
        return dp[n - 1][m - 1];
    }

        //print the matrix
        public static void printMatrix ( int[][] matrix){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++)
                    System.out.print(matrix[i][j] + " ");
                System.out.print("\n");
            }
        }


    public static void main(String[] args) {
        int[][] mat1 = {{1,3,1}, {1,5,1},{4,2,1}};
        int[][] mat2 = {{1, 1}, {0, 0}};
        System.out.println(minPathSum(mat1));
    }
}
