package Coding_Assesments.Microsoft;

import java.util.HashSet;

public class P1 {
    public static boolean solution (int[] A) {
        HashSet myArray = new HashSet();
        for(int i=0; i<A.length; i++) {   // adding elements to HashSet for constant time lookup
            myArray.add(Integer.valueOf(A[i]));
        }
        for(int i=0; i<A.length; i++) {   // now we look if there is another element in array who is greater or less by 1
            if(myArray.contains(A[i]-1) || myArray.contains(A[i]+1))
                return true;    // if we found one, we return true, no need to iterate more
        }
        return false;      // if we tried each combination and didn't pass the condition at least once, we return false
    }

    public static void main(String[] args) {
        int[] a = {12,10,17,19,2,0,1};
        System.out.println(solution(a));
    }

}
