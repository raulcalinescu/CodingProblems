package Sorting_Algorithms;
/*
[ 1, 3, 2, 0, 9, 4]

[1,3,2] and [0,9,4]

 */

public class MergeSort {

    public static void mergeSort(int a[], int l, int r) {
        if(r > l) {
            int middle = (r + l) / 2;     // to get the middle you always add the extremities before dividing
            mergeSort(a, l, middle);
            mergeSort(a, middle + 1, r);
            merge(a, l, middle, r);
        }
    }

    public static void merge(int a[], int l, int m, int r) {
        int s1 = m - l + 1;
        int s2 = r - m;

        int L[] = new int[s1];
        int R[] = new int[s2];

        //copy to temporary arrays
        for(int i=0; i<s1; i++)
            L[i] = a[l+i];
        for(int j=0; j<s2; j++)
            R[j] = a[m+1+j];

        // Merge the temporary arrays into the given one
        int i = 0, j = 0, k = l;
        while (i < s1 && j < s2) {   // we only have to get in this loop if both arrays have elements left
            if(L[i] < R[j]) {           // otherwise we can just add the remaining ones in another loop
                a[k] = L[i];
                i++; k++;
            } else {
                a[k] = R[j];
                j++; k++;
            }
        }
        // Copy the remaining elements
        while (i < s1) {        //if here, it means we had to re-arrange
            a[k] = L[i];
            i++; k++;
        }

        while (j < s2) {         // then, we were already in order and just copied the rest over
            a[k] = R[j];
            j++; k++;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {3,6,4,1,1};  // l = 0, r = 5

        mergeSort(a,0,4);
        for(int i=0; i<a.length; i++) {
            System.out.print(" " + a[i]);
        }

    }
}
