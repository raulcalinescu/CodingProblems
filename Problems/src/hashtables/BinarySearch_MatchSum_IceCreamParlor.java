package hashtables;
/*
* Each time Sunny and Johnny take a trip to the Ice Cream Parlor, they pool their money to buy ice cream. On any given day,
 * the parlor offers a line of flavors. Each flavor has a cost associated with it.

Given the value of money and the cost of each flavor for t trips to the Ice Cream Parlor, help Sunny and Johnny choose two
distinct flavors such that they spend their entire pool of money during each visit. ID numbers are the 1- based index number
associated with a cost.

For each trip to the parlor, print the ID numbers for the two types of ice cream that Sunny and Johnny purchase as two
space-separated integers on a new line. You must print the smaller ID first and the larger ID second.

EXAMPLE:
Print two space-separated integers denoting the respective indices for the two distinct flavors they choose to purchase
in ascending order. Recall that each ice cream flavor has a unique ID number in the inclusive range from 1 to |cost|

Sample Input

2
4
5
1 4 5 3 2
4
4
2 2 4 3

Sample Output

1 4
1 2

Constraints:

1 <= t <= 50
2 <= money <= 10 ^ 9
2 <= n <= 5 * 10 ^ 4
1 <= cost[i] <= 10 ^ 9

* */


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BinarySearch_MatchSum_IceCreamParlor {

    public static class HTObject {
        public Integer position;
        public Integer value;
    }
    private static LinkedList<HTObject>[] arr = new LinkedList[50000];
    // Complete the whatFlavors function below.


    static void whatFlavors(int[] cost, int money) {

        int diff1 = 0, diff2 = 0;
        for (int i = 0; i < cost.length; i++) {
            put(i+1, cost[i], cost);
        }

        Arrays.sort(cost);

        for (int i = 0; i < cost.length; i++) {
            if (money < cost[i]) continue;
            else {
                diff1 = get(cost[i], cost);
                diff2 = get(money - cost[i], cost);
                if(diff1 == -1 || diff2 == -1) continue;
                else {
                    if (diff2 > diff1)
                        System.out.println(diff1 + " " + diff2);
                    else
                        System.out.println(diff2 + " " + diff1);
                    break;
                }
            }
        }
        arr = new LinkedList[50000];
    }

    public static boolean binarySearchRecursive (int number, int low, int high, int[] arr) {
        if (low > high) {
            return false;
        }
        int mid = low + ((high - low) / 2);

        if (number == arr[mid]) {
            return true;
        } else if (number > arr[mid]) {
            return binarySearchRecursive(number, mid + 1, high, arr);
        } else {
            return binarySearchRecursive(number, low, mid - 1, arr);
        }
    }

    public static boolean binarySearchIterative (int number, int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (number == arr[mid]) {
                return true;
            } else if (number > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public static int get (Integer flavor, int[] cost) {
        int position;
        if (flavor <= 0)
            return -1;
        int index = Math.abs(flavor.hashCode() % cost.length);
        LinkedList<HTObject> items = arr[index];

        if (items == null)
            return -1;

        for (HTObject item : items) {
            if (item.value.equals(flavor) && item.position != -1) {
                position = item.position;
                item.position = -1;
                items.add(item);
                arr[index] = items;
                return position;
            }
        }

        return -1;
    }

    public static void put(Integer position, Integer value, int[] cost) {
        int index = Math.abs(value.hashCode() % cost.length);
        LinkedList<HTObject> items = arr[index];

        if(items == null) {
            items = new LinkedList<HTObject>();

            HTObject item = new HTObject();
            item.position = position;
            item.value = value;
            items.add(item);
            arr[index] = items;
        } else {
            HTObject item = new HTObject();
            item.position = position;
            item.value = value;

            items.add(item);

            arr[index] = items;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
            int[] cost = new int[] {2,2,3,5};
            int money = 4;
            whatFlavors(cost, money);
        }


}
