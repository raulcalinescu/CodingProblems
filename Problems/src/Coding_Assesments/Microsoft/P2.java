package Coding_Assesments.Microsoft;

public class P2 {
    // provide
    public static int solution(int[] A, int[] B) {
        //Data validation here
        if(A.length <= 1)  // enough to check A, we know A and B's length will be the same as mentioned [2,..100k]
            return -1;
        int leftArrA = 0, rightArrA = 0;   // initialize the two counts/sums to zero for arr A
        int leftArrB = 0, rightArrB = 0;   // initialize the two counts/sums to zero for arr B
        for (int i = 0; i < A.length; i++) {
            leftArrA += A[i] ;
            leftArrB += B[i] ;

            for(int j = i+1 ; j < A.length ; j++ ) {
                rightArrA += A[j];
                rightArrB += B[j];
            }

            // if all subArrays are equal to each other, return the index
            if (leftArrA == rightArrA && leftArrB == rightArrB && leftArrA == rightArrB)
                return i+1 ;
        }
        return 0;  // return
}

    public static void main(String[] args) {

    }
}
