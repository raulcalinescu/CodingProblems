package problems;
import java.util.Arrays;

public class HashFunction {
    String[] array;
    int arraysize;
    int itemsInArray = 0;

    HashFunction(int size) {
        arraysize = size;
        array = new String[size];
        Arrays.fill(array," ");

    }

    public void hashFunction(String[] strings, String[] array) {
        for (int i = 0; i < strings.length; i++) {
            String newElem = strings[i];
            array[Integer.parseInt(newElem)] = newElem;
        }
    }

    public void displayHashTable (String[] strings, String[] array) {
        for (int i = 0; i < arraysize; i++)
            System.out.print(i);
        System.out.print('\n');
        for (int i = 0; i < arraysize; i++)
            System.out.print(array[i]);
    }

    public static void main(String[] args) {
        HashFunction func = new HashFunction(10);
        String[] elementsToAdd = {"0", "3","6"};
        func.hashFunction(elementsToAdd,func.array);
        func.displayHashTable(elementsToAdd,func.array);

    }
}
