package EASY.space_matrix_control;

/*
On a plane there are n points with integer coordinates points[i] = [xi, yi].
Your task is to find the minimum time in seconds to visit all points.

You can move according to the next rules:

In one second always you can either move vertically, horizontally by one unit or diagonally
(it means to move one unit vertically and one unit horizontally in one second).

You have to visit the points in the same order as they appear in the array.
 */

public class minPointsTraversalTime {

    public static int minTimeToVisitAllPoints(int[][] points) {
        int min_time = 0;
        for(int i = 0; i < points.length - 1; i++) {
            min_time += Math.max(Math.abs(points[i+1][0] - points[i][0]),      // the min time is the max of coordinates difference
                    Math.abs(points[i+1][1] - points[i][1]));
        }
        return min_time;
    }

    
    //this solution works only when actual axis units are needed not time in seconds equivalence


    public static int minUnitsToVisitAllPoints(int[][] points) {
        if(points.length == 1 || points.length == 0)   //length of a 2D array is equal to the number of rows (i)
            return 0;

        if(points.length == 2)
            return (int) Math.sqrt((Math.pow(points[1][0] - points[0][0],2) +
                    Math.pow(points[1][1] - points[0][1],2)));

        int min_time = 0;
        for(int i = 0; i < points.length - 1; i++) {
            min_time += (int) Math.sqrt((Math.pow(points[i+1][0] - points[i][0],2) +
                    Math.pow(points[i+1][1] - points[i][1],2)));
        }
        return min_time;
    }

    public static void main(String[] args) {
        int[][] mat3 = {{1,1},{3,4},{-1,0}};
        int[][] mat2 = {{0,1},{3,4}};
        System.out.println(minTimeToVisitAllPoints(mat3));

    }
}
