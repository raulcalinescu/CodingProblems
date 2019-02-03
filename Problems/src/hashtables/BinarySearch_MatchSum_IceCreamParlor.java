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
    private static LinkedList<HTObject>[] arr = new LinkedList[100];
    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {

        int diff = 0;
        for (int i = 0; i < cost.length; i++) {
            put(i,cost[i], cost);
        }

        Arrays.sort(cost);

        for (int i = 0; i < cost.length; i++) {
            if (money < cost[i]) {}
            else {
                diff = get(money - cost[i], cost);
                if(diff == -1) {}
                else {
                    System.out.println(i + " " + diff);
                }
            }
        }

    }

    public static int get (Integer flavor, int[] cost) {
        if (flavor <= 0)
            return -1;
        int index = Math.abs(flavor.hashCode() % cost.length);
        LinkedList<HTObject> items = arr[index];

        if (items == null)
            return -1;

        for (HTObject item : items) {
            if (item.value.equals(flavor))
                return item.position;
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
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}
