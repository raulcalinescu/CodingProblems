package Sorting_Algorithms;

public class BubbleSort {

    public static void bubbleSort(int[] a) {
        boolean swap = false;

        for(int i=0; i<a.length; i++) {
            for(int j=0; j<a.length-1; j++) {
                if(a[j] > a[j+1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swap = true;
                }
            }
            if(swap == false)
                break;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {3,2,1,0,9,6};
        bubbleSort(a);
        for(int i=0; i<a.length; i++) {
            System.out.print(" " + a[i]);
        }
    }
}
