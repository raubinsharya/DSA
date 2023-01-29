package General.Sorting;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int arr[] = {1, 4, 3, 9, 6, 5, 8, 20, 11, 7};
        for (int i : sort(arr)) System.out.println(i);
    }

    private static int[] sort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int freq[] = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }
        int output[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            output[--freq[arr[i]]] = arr[i];
        }
        return output;
    }
}
