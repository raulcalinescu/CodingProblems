package Coding_Assesments;

import java.util.List;
import java.util.Arrays;
import java.util.*;

public class Atakama {

    /*
    Task
You are given an array of up to four non-negative integers, each less than 256.

Your task is to pack these integers into one number M so that the first element of the array occupies the first (or least significant) 8 bits of M; the second element occupies next 8 bits, and so on.

Return the obtained integer M as unsigned integer.

Note
As indicated the first 8 bits are the least significant bits of M, meaning the right-most bits of the integer.
For further clarification see the following example.

Specification
Challenge.arrayPacking(array)

Parameters
array: List<Integer> - up to four unsigned integers
Return Value
Integer - an unsigned integer
Constraints
array.length == 3
0 ≤ array[i] < 256
     */

    //Take an array of three numbers and pack their binary values into a single integer.

    public static Integer arrayPacking(List<Integer> integers) {
        if (integers.size() == 3) {                // checking for the constraints
            int decimal = 0;
            for (int i=0; i< integers.size(); i++) {
                if(integers.indexOf(i) < 256 || integers.indexOf(i) >= 0) {
                    decimal = decimal + integers.indexOf(i) << 8 * i;
                } else {
                    throw new IllegalArgumentException();    // The argument is out of bounds
                }
            }
            return decimal;
        } else {
            throw new IllegalArgumentException();  //  Argument was out of range.
        }

    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(Integer.valueOf(24));
        integers.add(Integer.valueOf(85));
        integers.add(Integer.valueOf(0));
        System.out.println(integers.indexOf(2));
        System.out.println(arrayPacking(integers));
    }
}
