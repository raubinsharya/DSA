package Recursion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintSubSequence {
    private static void printSubSequence(int arr[], int idx, int n, LinkedList<Integer> list) {
        if (idx == n) {
            if (list.isEmpty()) System.out.print("{}"); // if index reached n in not pick condition then it will print empty
            for (int num : list) System.out.print(num + " ");
            System.out.println();
            return;
        }
        printSubSequence(arr, idx + 1, n, list); // not Pick condition
        list.add(arr[idx]);
        printSubSequence(arr, idx + 1, n, list); // pick condition
        list.removeLast();
    }

    public static void main(String[] args) {
        int arr[] = {3, 1, 2};
        printSubSequence(arr, 0, arr.length, new LinkedList<>());
    }
}
