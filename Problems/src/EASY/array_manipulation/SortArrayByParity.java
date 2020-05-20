package EASY.array_manipulation;
/*
Given an array A of non-negative integers, return an array consisting of all the even elements of A,
followed by all the odd elements of A.
You may return any answer array that satisfies this condition.

Example 1:
Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 */
public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] A) {
        int parInd = 0; // keep a parity index to move the even elements to
        for(int i=0; i < A.length; i++) {
            int temp; // keep a temp to swap even values to the parity locations
            if(A[i]%2==0 && parInd==i) {
                parInd++;
            } else if(A[i]%2==0) {
                temp = A[i];
                A[i] = A[parInd];
                A[parInd] = temp;
                parInd++;
            } // if non of the branches are true, just iterate to next value in array
        }
        return A;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 6, 7};
        int[] b = sortArrayByParity(a);

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }
    }
}
