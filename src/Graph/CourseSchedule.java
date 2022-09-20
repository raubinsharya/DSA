package Graph;

import java.util.*;

// Problem Link
// https://leetcode.com/problems/course-schedule/
// GFG https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=prerequisite-tasks
public class CourseSchedule {
    public boolean isPossible(int V, int[][] prerequisites) {
        int row = prerequisites.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < row; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int inDegree[] = new int[V];
        List<Integer> topo = new ArrayList<>();
        for (List<Integer> i : adj) {
            for (int node : i) {
                inDegree[node]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo.add(node);
            for (int i : adj.get(node)) {
                if (--inDegree[i] == 0) queue.add(i);
            }
        }
        if (topo.size() == V) return true;
        return false;
    }
}
