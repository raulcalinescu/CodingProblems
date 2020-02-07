package EASY.array_manipulation;


/*
We are given a list nums of integers representing a list compressed with run-length encoding.
Consider each adjacent pair of elements [a, b] = [nums[2*i], nums[2*i+1]] (with i >= 0).
For each such pair, there are a elements with value b in the decompressed list.
Return the decompressed list.

Key concept:
Integer array concatenation:

int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int aLen = array1.length;
        int bLen = array2.length;
        int[] result = new int[aLen + bLen];
        System.arraycopy(array1, 0, result, 0, aLen);
        System.arraycopy(array2, 0, result, aLen, bLen);

 */
// solution went from first try with 37 MB less than 100% of java submissions, and 3ms faster than 74%
public class DecompressEncodedArray {
    public static int[] decompressRLElist(int[] nums) {
        int[] temp, sum = new int[]{}, result = new int[0];
        int prev_length = 0;

	    for(int i = 0; i < nums.length; i+=2) {
	        int temp_length = nums[i];
	        temp = new int[temp_length];

            while(nums[i] > 0) {
                for(int j = 0; j < temp_length; j++) {
                    temp[j] = nums[i+1];
                }
                nums[i]--;
            }

            int sum_length = sum.length + temp_length;
            result = new int[sum_length];                                   // keep a new array to copy the sum of the past
            System.arraycopy(sum,0,result,0,sum.length);     // DATA_STRUCTURES.arrays and the newly constructed after each
            System.arraycopy(temp,0,result, sum.length, temp.length);   // frequency iteration
            sum = result;

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] result;
        result = decompressRLElist(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
