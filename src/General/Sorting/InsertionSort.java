package General.Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {1, 4, 3, 9, 6, 5, 8, 20, 11, 7};
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > num) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = num;
        }
        for (int i : arr) System.out.println(i);
    }
}
