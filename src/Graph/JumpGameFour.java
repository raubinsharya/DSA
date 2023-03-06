package Graph;

import Utils.Pair;

import java.util.*;
// https://leetcode.com/problems/jump-game-iv/description/
public class JumpGameFour {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        boolean visited[] = new boolean[n + 1];
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = hm.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            hm.put(arr[i], list);
        }
        int steps = Integer.MAX_VALUE;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(0, 0));
        visited[0] = true;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> temp = queue.poll();

            if (temp.first == n - 1) {
                steps = Math.min(steps, temp.second);
                return steps;
            }

            int left = temp.first - 1;
            int right = temp.first + 1;

            if (right >= 0 && right < n && !visited[right]) {
                queue.offer(new Pair<>(right, temp.second + 1));
                visited[right] = true;
            }

            if (left >= 0 && left < n && !visited[left]) {
                queue.offer(new Pair<>(left, temp.second + 1));
                visited[left] = true;
            }


            List<Integer> list = hm.get(arr[temp.first]);
            for (int idx : list) {
                if (!visited[idx]) {
                    queue.offer(new Pair<>(idx, temp.second + 1));
                    visited[idx] = true;
                }
            }
            list.clear();
        }
        return steps;
    }
}
