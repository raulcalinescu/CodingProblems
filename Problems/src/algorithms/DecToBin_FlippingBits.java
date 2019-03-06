package algorithms;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/*
Negating Operator (~) flips bits !!! BUT:

Why ~2 is -3 has to do with how numbers are represented bitwise.
Numbers are represented as two's complement.

So, 2 is the binary value

00000010

And ~2 flips the bits so the value is now:

11111101

Which, is the binary representation of -3.
So using only n = ~n won't be enough for this case


 */

public class DecToBin_FlippingBits {


        // Complete the flippingBits function below.
        static long flippingBits(long n) {
            int binary[] = new int[32], conv[] = new int[32];
            int index = 0;
            long sum = 0;

            while(n > 0) {      // DEC to BIN raw conversion below
                binary[index++] = (int)(n%2);
                n = n/2;        // save each remainder as a bit in an array
            }                   // and divide by 2 to get the next 2 base

            for(int i = binary.length - 1; i >= 0 ; i--) {
                sum = sum + (long)(Math.pow(2,i) * flipBinary(binary[i]));
            }
            return sum;
    }

        static int flipBinary(int n) {
            n = (n == 0) ? 1:0;
            return n;
        }

        private static final Scanner scanner = new Scanner(System.in);

        public static void main(String[] args)  {

            int q = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int qItr = 0; qItr < q; qItr++) {
                long n = scanner.nextLong();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                long result = flippingBits(n);
                System.out.println(result);
            }



            scanner.close();
        }


}

