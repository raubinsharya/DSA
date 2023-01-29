package General.Sorting;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        sort(arr);
        for (int i : arr) System.out.println(i);
    }

    private static void sort(int[] arr) {
        int n = arr.length;
        // build heap first
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // picking the largest number and sorting the array
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int idx) {
        int largest = idx;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;
        if (left < n && arr[left] > arr[largest]) largest = left;
        if (right < n && arr[right] > arr[largest]) largest = right;
        if (largest != idx) {
            int temp = arr[largest];
            arr[largest] = arr[idx];
            arr[idx] = temp;
            heapify(arr, n, largest);
        }
    }
}
