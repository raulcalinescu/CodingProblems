package DATA_STRUCTURES.Arrays;

import java.util.*;

public class HourGlass {

    // Complete the hourglassSum function below.

    /* Optimal Solution:

       int maxsum = -1000,jj = 0;
    for(int i = 0;i < 4;i++) {
        int sum = 0;
        for(int j = jj;j < jj+3;j++) {
            sum += matrix[i][j];
            if(j==jj) sum += matrix[i+1][jj+1];
            sum += matrix[i+2][j];
        }
        jj = (jj < 3) ? jj+1 : 0;
        if(sum > maxsum) maxsum = sum;
        if(jj != 0) i--;
    }
     */

    static int hourglassSum(int[][] arr) {
        int max=-999999 ,sum = 0, c=0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                while (c < 3) {
                    sum = sum + arr[i][j+c];
                    if (c == 1)
                        sum = sum + arr[i + c][j + c];
                    sum = sum + arr[i + 2][j+c];
                    c++;
                }
                c = 0;
                if (sum > max)
                    max = sum;
                sum = 0;
            }
        }
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int[][] arr = new int[6][6];
        int[][] arr = {{1,1,1,0,0,0},{0,1,0,0,0,0},{1,1,1,0,0,0},{0,0,2,1,2,0},{0,0,0,2,0,0},{0,0,2,2,2,0}};

        /*for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }*/

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }

        int result = hourglassSum(arr);
        System.out.println("\n" + result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close(); */
    }
}
