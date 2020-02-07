package Easy.space_matrix_control;
/*
Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal,
switching the row and column indices of the matrix:

Example 1:
Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]

Example 2:
Input: [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]

 */

public class TransposeMatrix {

    public static int[][] transpose(int[][] matrix) {
        //create a new matrix with the reversed indexes
        int m = matrix[0].length;
        int n = matrix.length;
        int[][] trans = new int[m][n];

        // traverse the rows of old matrix, and the columns of transpose
        for(int i=0; i<matrix.length; i++) {
            //traversing the columns of old matrix which creates the rows of transpose
            for(int j=0; j<matrix[0].length;j++) {
                trans[j][i]=matrix[i][j];               // assign the reversed indexes to fill in the transpose
            }
        }
        return trans;
    }


    //print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[][] mat1 = {{1,2,3},{4,5,6}};
        int[][] mat2 = {{1,1},{0,0}};
       printMatrix(transpose(mat1));
    }
}
