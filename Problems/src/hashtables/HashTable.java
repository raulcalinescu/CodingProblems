package hashtables;

import java.util.*;
import java.lang.Math;


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

public class HashTable {

    public static class HTObject {
        public String key;
        public Integer value;
    }

    public static final int ARR_SIZE = 128;
    private LinkedList<HTObject>[] arr = new LinkedList[ARR_SIZE];

    public HashTable() {
        for (int i=0; i<ARR_SIZE; i++){
            arr[i] = null;
        }
    }

    public void put(String key, Integer value){
        int index = Math.abs(key.hashCode() % ARR_SIZE);
        LinkedList<HTObject> items = arr[index];

        if(items == null) {
            items = new LinkedList<HTObject>();

            HTObject item = new HTObject();
            item.key = key;
            item.value = value;
            items.add(item);

            arr[index] = items;
        } else {
            for(HTObject item : items) {
                if (item.key.equals(key)) {
                    item.value = value;
                    return;
                }
            }
            HTObject item = new HTObject();
            item.key = key;
            item.value = value;

            items.add(item);
        }
    }

    private HTObject getObj(String key) {
        if(key == null)
            return null;

        int index = Math.abs(key.hashCode() % ARR_SIZE);
        LinkedList<HTObject> items = arr[index];

        if (items == null)
            return null;

        for (HTObject item : items) {
            if(item.key.equals(key))
                return item;
        }
        return null;

    }

    public Integer get(String key) {
        HTObject item = getObj(key);

        if(item == null)
            return null;
        else
            return
                    item.value;
    }


    public void delete(String key) {
        int index = Math.abs(key.hashCode() % ARR_SIZE);
        LinkedList<HTObject> items = arr[index];

        if (items == null)
            return;

        for (HTObject item : items)
            if (item.key.equals(key)) {
                items.remove(item);
                return;
            }
    }

    public static void main(String args[]) {
        System.out.println(" Test ");
    }
}