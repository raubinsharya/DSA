package General.Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {1, 4, 3, 9, 6, 5, 8, 20, 11, 7};
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        for (int i : arr) System.out.println(i);
    }
}
