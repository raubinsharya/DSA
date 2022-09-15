import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int arr[] = {0, 1, 2, 3, 4, 5, 7, 8, 9, 11};
        System.out.println(findMissing(arr, 0, arr.length - 1));
    }

    private static int findMissing(int[] arr, int start, int end) {
        if (start > end) return end + 1;
        if (arr[start] != start) return start;
        int mid = (start + end) / 2;
        if (arr[mid] == mid) return findMissing(arr, mid+1, end);
        return findMissing(arr, start, mid);
    }
}

