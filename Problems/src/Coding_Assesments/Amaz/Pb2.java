package Coding_Assesments.Amaz;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class Pb2 {



    int minimumDays(int rows, int columns, List<List<Integer>> grid) {
        List<List<Integer>> update = new ArrayList<>(4);
        update.addAll(grid);
        // update.forEach(System.out::println);
        int sum =0, count=0;
        int n = rows * columns;
        while(sum != n) {
            sum=0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (grid.get(i).get(j)==1) {
                        updateAll(i,j,update);
                    }
                }
            }
            grid.clear();
            grid.addAll(update);
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    sum = sum+ update.get(i).get(j);
                }
            }
            count++;
        }
        return count;
    }

    private void updateAll(int i, int j, List<List<Integer>> visit) {
        visit.get(i).add(j,1);
        if(i+1< visit.size()){
            visit.get(i+1).add(j,1);
        }
        if(i>0){
            visit.get(i-1).add(j,1);
        }
        if(j>0){
            visit.get(i).add(j-1,1);
        }
        if(j+1 < visit.get(0).size()){
            visit.get(i).add(j+1,1);
        }
    }
}
