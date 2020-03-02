package Coding_Assesments.Amaz;

/*
The GCD of three or more numbers equals the product of the prime factors common to all the numbers,
but it can also be calculated by repeatedly taking the GCDs of pairs of numbers.
 */
public class GCD {

    // create a modular approach and divide solution into smaller problems,
    // so first we create another small method to compute the GCD only for two numbers
    public static int gcdOfTwoNumbers(int num1, int num2) {
        if (num1 == 0)
            return num2; // if the remainder is 0, we know initial num1 (prior to recursive call) is the GCD
        else
            return gcdOfTwoNumbers(num2 % num1, num1); // recursively divide on the remainder
                                                        // until modulus returns 0, so the other number is the GCD
    }

    //then we implement the generalizedGCD method and we call gcdOfTwoNumbers for each number within the given array
    public static int generalizedGCD(int num, int[] arr)
    {
        int gcd = arr[0];           // start from computing the gcd for first and the number at the next index (1)
        for(int i = 1; i < num; i++) {
            gcd = gcdOfTwoNumbers(arr[i], gcd); // then call gcd for each number with the previous two number's gcd
            if(gcd == 1)
                return 1;   // no need to go through the rest of the loop since we found two numbers who's gcd is 1
        }
        return gcd;
    }

    public static void main(String[] args) {
        int[] arr = {4,4,8,16,24};
        System.out.println(generalizedGCD(5,arr));
    }
}
