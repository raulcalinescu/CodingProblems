package hashtables;

import java.util.*;

/* Creating a HashTable
*        Chaining example for collisions
*        It is possible that the hash function will return the same
*        value (meaning same array location) for different keys. This is called a “collision”.
*        A hash table must have a way to handle collisions. In this implementation we use “chaining”
*        with a LinkedList to handle collisions. Each location in the array contains a LinkedList.
*
*  The basic parts of any hash table are: the array,
*                                         the hash function,
*                                         and handling collisions.
*
*  The basic methods include get(), put(), and delete().
*
* */

public class Solution{

    public static class HTObject {
        public String key;
        public Integer value;
    }

    public static final int ARR_SIZE = 128;
    private LinkedList<HTObject>[] arr = new LinkedList[ARR_SIZE];

    public Solution() {

    }

    public void put(String skey, Integer ivalue){


    }

    public static void main(String args[]){

   }
}
