package dynamicprog;
import java.util.*;

// print minimum number of perfect squares that add up to a given number

public class PerfectSquares {

    static int perfectSquare(int n) {
        if (n <= 0) {
            return 0;
        }
        List<Integer> cntPerfectSquare = new ArrayList<>();
        cntPerfectSquare.add(0);

        while (cntPerfectSquare.size() <= n) {
            int size = cntPerfectSquare.size();
            int cntSquares = Integer.MAX_VALUE;

            for (int i = 1; i*i <= size; i++) {
              cntSquares = Math.min(cntSquares, cntPerfectSquare.get(size - i*i) + 1);
            }
            cntPerfectSquare.add(cntSquares);
        }

       return cntPerfectSquare.get(n);
    }


    public static void main(String args[]) {
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        int result = perfectSquare(n);
        System.out.print(result);
    }

}