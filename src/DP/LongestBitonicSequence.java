package DP;
// https://www.codingninjas.com/codestudio/problems/longest-bitonic-sequence_1062688?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
public class LongestBitonicSequence {
    public static int longestBitonicSequence(int[] arr, int n) {
        int dpForward[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dpForward[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dpForward[j] + 1 > dpForward[i]) {
                    dpForward[i] = dpForward[j] + 1;
                }
            }
        }
        int dpBackward[] = new int[n + 1];
        int maxi = 1;
        for (int i = n - 1; i >= 0; i--) {
            dpBackward[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && dpBackward[j] + 1 > dpBackward[i]) {
                    dpBackward[i] = dpBackward[j] + 1;
                }
            }
            maxi = Math.max(maxi, dpBackward[i] + dpForward[i] - 1);
        }
        return maxi;
    }
}
