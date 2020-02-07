package DATA_STRUCTURES.Arrays;


/* Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:

nums = [ 1, 2, 3, 3]
val = 3

1 2 3




 */



public class removeElement {

    public static int removeElement(int[] nums, int val) {

        //the fast two-pointers approach. O(n)

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;



        /* My time consuming solution O(n^3)

        int length = nums.length;
        for (int i=0; i<length; i++) {
            while (nums[i] == val) {
                for(int j=i; j<length-1;j++) {
                    nums[j] = nums[j+1];
                }
                length--;
                if (i == length) break;
            }
        }

        return length; */
    }

    public static void main(String[] args) {
        int[] a = {1,2,4,4};
        int val = 4;
        System.out.println(removeElement(a,val));

    }

}
