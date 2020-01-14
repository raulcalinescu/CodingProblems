package Easy.array_manipulation;


/*
Integer array concatenation:

int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};
        int aLen = array1.length;
        int bLen = array2.length;
        int[] result = new int[aLen + bLen];
        System.arraycopy(array1, 0, result, 0, aLen);
        System.arraycopy(array2, 0, result, aLen, bLen);

 */

public class DecompressEncodedArray {
    public static int[] decompressRLElist(int[] nums) {
        int[] temp = new int[]{};
	    if(nums.length == 2) {
		    while(nums[0] > 0) {
			
		    }
	    }
	    for(int i = 0; i < nums.length; i+=2) {
            while(nums[i] > 0) {
                
                nums[i]--;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        System.out.println(decompressRLElist(nums));
    }
}
