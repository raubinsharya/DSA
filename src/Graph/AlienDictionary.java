package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Problem Link
// GFG https://practice.geeksforgeeks.org/problems/alien-dictionary/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=alien-dictionary

public class AlienDictionary {
    public String findOrder(String[] dict, int N, int K) {
        String res = "";
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < K; i++) {
            String first = dict[i - 1];
            String second = dict[i];
            int len = Math.min(first.length(), second.length());
            for (int k = 0; k < len; k++) {
                if (first.charAt(k) != second.charAt(k)) {
                    adj.get(first.charAt(k) - 'a').add(second.charAt(k) - 'a');
                    break;
                }
            }
        }
        int inOrder[] = new int[K];
        for (ArrayList<Integer> i : adj)
            for (int node : i) inOrder[node]++;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < K; i++) if (inOrder[i] == 0) queue.offer(i);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int i : adj.get(node)) {
                if (--inOrder[i] == 0) queue.offer(i);
            }
        }

        for (int i : result) {
            res += (char) (i + (int) 'a');
        }
        return res;
    }
}
