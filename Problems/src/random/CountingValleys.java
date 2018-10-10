package random;


/*
* Gary is an avid hiker. He tracks his hikes meticulously, paying close attention to small details like topography.
* During his last hike he took exactly steps. For every step he took, he noted if it was an uphill, , or a downhill, step.
* Gary's hikes start and end at sea level and each step up or down represents a unit change in altitude. We define the following terms:

    A mountain is a sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
    A valley is a sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.

Given Gary's sequence of up and down steps during his last hike, find and print the number of valleys he walked through.

For example, if Gary's path is , he first enters a valley units deep. Then he climbs out an up onto a mountain units high. Finally, he returns to sea level and ends his hike.

Function Description

Complete the countingValleys function in the editor below. It must return an integer that denotes the number of valleys Gary traversed.

countingValleys has the following parameter(s):

    n: the number of steps Gary takes
    s: a string describing his path

Input Format

The first line contains an integer , the number of steps in Gary's hike.
The second line contains a single string , of characters that describe his path.

Constraints

Output Format
Print a single integer that denotes the number of valleys Gary walked through during his hike.

Sample Input
8
UDDDUDUU

Sample Output
1
Explanation

If we represent _ as sea level, a step up as /, and a step down as \, Gary's hike can be drawn as:

_/\      _
   \    /
    \/\/

He enters and leaves one valley.
*
*
* */

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(String s) {
        int valleyCount = 0, goingUp = 0, goingDown = 0, steps = 0;
        boolean valley = false;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'D') {
                if (goingDown == goingUp)    // we are going down and if we're at sea level
                    valley = true;           // means we enter a valley
                goingDown++;
            } else if (s.charAt(i) == 'U') {
                if (goingDown == goingUp)   // we are going up and if we're at sea level
                    valley = false;         // means we are climbing a mountain
                goingUp++;
            }

            if(goingUp == goingDown && valley)      // if valley is still true and counters are equal
                valleyCount++;                      // means we are coming from a valley and we are now
        }                                           // at sea level, so we count in a complete valley
        return valleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String s = scanner.nextLine();

        int result = countingValleys(s);

        System.out.println(result);
    }
}
