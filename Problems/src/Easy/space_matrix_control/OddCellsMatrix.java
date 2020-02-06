package Easy.space_matrix_control;

/*
Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where
indices[i] = [ri, ci].
For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.

Return the number of cells with odd values in the matrix after applying the increment to all indices.
1 <= n <= 50
1 <= m <= 50
1 <= indices.length <= 100
0 <= indices[i][0] < n
0 <= indices[i][1] < m

indices[0,1],[1,1]
n = 2, m = 3
[0,0,0]    ->       [1,2,1]     ->      [1,3,1]
[0,0,0]             [0,1,0]             [1,3,1]

indices[0,1],[1,1]


indices[1,1],[0,0]
n = 2, m = 2
[0,0]    ->       [0,1]     ->      [2,2]
[0,0]             [1,2]             [2,2]

 */

public class OddCellsMatrix {

    public static int oddCells(int n, int m, int[][] indices) {
        int count = 0;
        int[][] mat = new int[n][m];

        //getting the indices for the columns and rows
        for(int i = 0; i < indices.length; i++) {
            //incrementing the whole row by one
            for(int j = 0; j < n; j++) {

            }
            //incrementing the whole column by one
            for(int k = 0; k < m; k++) {

            }
        }
        //incrementing the count for odd values within the matrix
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(mat[i][j]%2 != 0)
                    count++;

        return count;
    }

    public static void main(String[] args) {
        int[][] mat1 = {{0,1},{1,1}};
        int[][] mat2 = {{1,1},{0,0}};
        System.out.println(oddCells(2,3,mat1));
    }
}
