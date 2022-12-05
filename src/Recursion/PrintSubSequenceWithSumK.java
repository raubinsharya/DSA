package Recursion;

import java.util.LinkedList;

public class PrintSubSequenceWithSumK {
    private static void printSubSequence(int arr[], int idx, int n, int k, int sum, LinkedList<Integer> ds) {
        if (idx == n) {
            if (sum == k) {
                for (int num : ds) System.out.print(num + " ");
                System.out.println();
            }
            return;
        }
        ds.add(arr[idx]);
        printSubSequence(arr, idx + 1, n, k, sum + arr[idx], ds);// pick condition then element will be added to sum
        ds.removeLast();
        printSubSequence(arr, idx + 1, n, k, sum, ds); // not pick condition then sum element will not be added to sum
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        printSubSequence(arr, 0, arr.length, 2, 0, new LinkedList<>());
    }
}
