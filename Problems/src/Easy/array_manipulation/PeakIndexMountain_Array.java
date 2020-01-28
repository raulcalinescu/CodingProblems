package Easy.array_manipulation;

/*
Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].


    [1,2,3,2,1]
1 < 2
2 < 3
3 < 2 No  -> peak.

    [0,1,10,9,8,7]
    [2,3,1]

 */

// took 5 min to solve and submit.

public class PeakIndexMountain_Array {

    public int peakIndexInMountainArray(int[] A) {
        if (A.length < 3 || A.length > 10000)
            return 0;

        for(int i = 0; i < A.length - 1; i++) {
            if(A[i] < A[i+1])
                continue;
            else
                return i;
        }
        return 0;
    }
}
