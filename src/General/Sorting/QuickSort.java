package General.Sorting;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {1, 4, 3, 9, 6, 5, 8, 20, 11, 7};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) System.out.println(i);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);
            quickSort(arr, l, pivot - 1);
            quickSort(arr, pivot + 1, r);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (arr[i] <= pivot) i++;
            while (arr[j] > pivot) j--;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = pivot;
        arr[low] = temp;
        return j;
    }
}
