package Sorting_Algorithms;

[ 1, 3, 2, 0, 9, 4]

[1,3,2] and [0,9,4]

public class MergeSort {

    public static void mergeSort(int a[], int l, int r) {
        if(r > l) {
            int middle = (r - l) / 2;
            mergeSort(a, l, middle);
            mergeSort(a, middle + 1, r);
            merge(a, l, middle, r);
        }
    }

    public static void merge(int a[], int l, int m, int r) {
        int s1 = m - l + 1;
        int s2 = r - m;
        int k = l;

        int L[] = new int[s1];
        int R[] = new int[s2];

        for(int i=0; i<s1; i++)
            L[i] = a[k+i];
        for(int j=0; j<s2; j++)
            R[j] = a[m+1+j];
    }

    public static void main(String[] args) {

    }
}
