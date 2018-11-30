package strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ValidIfSameCountCharacters {

    // Complete the isValid function below.
    static String isValid(String s) {
        int cnt = 0;
        boolean firsTime = true, valid = true;
        Collection<Integer> values;
        Map chars = new HashMap<String, Integer>();
        int temp = 0;

        char[] c = s.toCharArray();

        for (int i = 0; i < c.length; i++)
            if (chars.containsKey(c[i]))
                chars.put(c[i], (int) chars.get(c[i]) + 1);
            else
                chars.put(c[i], 1);

        values = chars.values();
        Integer[] targetArray = values.toArray(new Integer[values.size()]);

        for (Integer i : targetArray) {
            if (i == targetArray[0]) {
                cnt = targetArray[0];
                continue;
            }

            if (i == cnt) continue;
            else if (i == 1 && firsTime) {
                firsTime = false;
                continue;
            }
            else if (i == cnt+1 && firsTime) {
                firsTime = false;
                continue;
            }
            else {
                valid = false;
                break;
            }
        }
        return valid ? "YES" : "NO";
    }




    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println(result);

        scanner.close();
    }
}
