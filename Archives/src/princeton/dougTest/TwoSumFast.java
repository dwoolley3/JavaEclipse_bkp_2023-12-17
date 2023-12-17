package dougTest;
/*************************************************************************
 *  A program with N log N running time. Read in N integers
 *  and counts the number of pairs that sum to exactly 0.
 *************************************************************************/

import java.util.Arrays;

public class TwoSumFast {

    // print distinct pairs (i, j) such that a[i] + a[j] = 0
    public static void printAll(int[] a) {
        int N = a.length;
        Arrays.sort(a);
        for (int i = 0; i < N; i++) {
            int j = Arrays.binarySearch(a, -a[i]);
            if (j > i) StdOut.println(a[i] + " " + a[j]);
        }
    } 

    // return number of distinct pairs (i, j) such that a[i] + a[j] = 0
    public static int count(int[] a) {
        int N = a.length;
        Arrays.sort(a);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int j = Arrays.binarySearch(a, -a[i]);
            if (j > i) cnt++;
        }
        return cnt;
    } 

    public static void main(String[] args)  { 
    	int[] a = {-405375, 1, 2, 405375, -192459, 3,4, 192459,	-77867, 5, 77867};
        int cnt = count(a);
        StdOut.println(cnt);
        printAll(a);
    } 
} 
