package DATA_STRUCTURES.Lists;


import java.util.ArrayList;
import java.util.List;
/*
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
For numbers which are multiples of both three and five output “FizzBuzz”.

 */

public class FizzBuzz {

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();   // List is an abstract class so have to initialize it as a type of List
        for(int i=1; i<=n; i++) {
            if(i%15==0) {
                list.add("FizzBuzz");
                continue;
            }
            if(i%3==0) {
                list.add("Fizz");
                continue;
            }
            if(i%5==0) {
                list.add("Buzz");
                continue;
            }
            list.add(String.valueOf(i));
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = fizzBuzz(35);
        for(String s: list) {
            System.out.println(s);
        }
    }
}
