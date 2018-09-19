package algorithms;

import java.util.*;
import java.lang.Math;

class LoopsValuesReferences{

    public static void printSeries(int a, int b, int n) {
        int sum = a;

        for (int i =0; i < n; i++) {
            sum = sum + b * (int)Math.round(Math.pow(2,i));
            System.out.print(sum+" ");
        }
        System.out.print("\n");
    }

    public static void main(String []argh){
        ArrayList <int[]> queryValues = new ArrayList<int[]>();
        int threeVal[];

        Scanner in = new Scanner(System.in);
        int t=in.nextInt();

        for(int i=0;i<t;i++){
            queryValues.add(i,new int[]{in.nextInt(),in.nextInt(),in.nextInt()});
        }

        for(int i = 0; i < t; i++) {
            threeVal = queryValues.get(i);
            printSeries(threeVal[0],threeVal[1],threeVal[2]);
        }

        in.close();
    }
}