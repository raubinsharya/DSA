package General.Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {1, 4, 3, 9, 6, 5, 8, 20, 11, 7};
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) System.out.println(i);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int ll = m - l + 1;
        int rr = r - m;
        int left[] = new int[ll];
        int right[] = new int[rr];
        for (int i = 0; i < ll; i++) {
            left[i] = arr[i + l];
        }
        for (int i = 0; i < rr; i++) {
            right[i] = arr[i + m + 1];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < ll && j < rr) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < ll) {
            arr[k++] = left[i++];
        }
        while (j < rr) {
            arr[k++] = right[j++];
        }
    }
}
