package random;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpingClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumps = 0, zeros = 0;

        for (int i = 0; i < c.length; i++) {
            if (c[i] == 0) {
                zeros++;

            } else {
                    jumps = jumps + (zeros - 1) / 2 + 1;
                    zeros = 0;
            }
        }
        return jumps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int n = scanner.nextInt();

        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            System.out.print(c[i]);
        }

        int result = jumpingOnClouds(c);
        System.out.println("\n" + result);

        scanner.close();
    }
}

