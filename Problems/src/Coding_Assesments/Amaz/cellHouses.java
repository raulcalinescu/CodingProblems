package Coding_Assesments.Amaz;

import java.util.ArrayList;
import java.util.List;

public class cellHouses {

    public static List<Integer> cellCompete(int[] states, int days)
    {   List<Integer> result = new ArrayList<Integer>(0);
        if(states.length != 8 || days < 1)
            return result;

        int currentHouse = 0, prevHouse = 0, nextHouse = 0;
        // go through each house
        while(currentHouse < states.length) {
            if(currentHouse < states.length - 1)    // if currentHouse is not the last House, set nextHouse
                nextHouse = states[currentHouse + 1];
            else if (currentHouse == states.length - 1)
                nextHouse = 0;

            if(nextHouse == prevHouse) {    //
                prevHouse = states[currentHouse];
                states[currentHouse] = 0;
            } else {
                prevHouse = states[currentHouse];
                states[currentHouse] = 1;
            }
            currentHouse++;
        }

        for(int i = 0; i < states.length; i++)
            result.add(states[i]);

        return result;
    }

    public static void main(String[] args) {
        int[] states = {1,0,1,1,0,0,1,1};
        int days = 1;
        List<Integer> res = cellCompete(states,days);
        for(Integer i : res) {
            System.out.print(i + " ");
        }

    }
}
