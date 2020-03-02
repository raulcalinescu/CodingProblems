package MEDIUM.Matrices;
/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:
11110
11010
11000
00000
Output: 1

Example 2:
11000
11000
00100
00011
Output: 3
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
	    int numIslands = 0;
	    for (int row=0; row<grid.length; row++)
	        for (int col=0; col<grid[0].length; col++)
		        if(grid[row][col]=='1') {
		            numIslands++;
		            dfs(grid,row,col);
		        }
	return numIslands;
    }
    public void dfs(char[][] grid, int row, int col) {
        int numberOfRows = grid.length;
        int numberOfCols = grid[0].length;
        if(row < 0 || col < 0 || row <= numberOfRows || col <= numberOfCols || grid[row][col] == '0')
            return;

    }
    public void main(String[] args) {

    }

}
