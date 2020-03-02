package Coding_Assesments.Amaz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cells {

    public static List<Integer> cellCompete(int[] states, int days) {

        List<Integer> result = new ArrayList<Integer>(0);
        if (states.length != 8 || days < 1)
            return result;

        Map<Integer, Integer> seen = new HashMap();

        int state = 0; // representing state of house
        for (int i = 0; i < 8; ++i) {
            if (states[i] > 0)
                state ^= 1 << i;
        }

        // While days remaining, simulate a day
        while (days > 0) {
            // If this is a cycle, fast forward by
            // seen.get(state) - N, the period of the cycle.
            if (seen.containsKey(state)) {
                days %= seen.get(state) - days;
            }
            seen.put(state, days);

            if (days >= 1) {
                days--;
                state = nextDay(state);
            }
        }

        // Convert the state back to the required answer.
        int[] ans = new int[8];
        for (int i = 0; i < 8; ++i) {
            if (((state >> i) & 1) > 0) {
                ans[i] = 1;
            }
        }

        for (int i = 0; i < ans.length; i++) // store result in a List type data
            result.add(ans[i]);  // structure as indicated in the return type

        return result;
    }

    public static int nextDay(int state) {
        int ans = 0;

        // We only loop from 1 to 6 as 0 and 7 only have one neighbor.
        for (int i = 1; i <= 6; ++i) {
            if (((state >> (i - 1)) & 1) == ((state >> (i + 1)) & 1)) {
                ans ^= 1 << i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] states = {1, 0, 1, 1, 0, 0, 1, 1};
        int days = 1;
        List<Integer> res = cellCompete(states, days);
        for (Integer i : res) {
            System.out.print(i + " ");
        }
    }
}
