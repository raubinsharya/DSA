package Graph;

import java.util.Arrays;

class FindTheCityWithTheSmallestNumberOfNeighbours {
    int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n];
        for (int rows[] : dist) Arrays.fill(rows, Integer.MAX_VALUE);
        for (int rows[] : edges) {
            int u = rows[0];
            int v = rows[1];
            int wt = rows[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }
        for (int i = 0; i < n; i++) dist[i][i] = 0;
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][via] == Integer.MAX_VALUE ||
                            dist[via][j] == Integer.MAX_VALUE)
                        continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][via] + dist[via][j]);
                }
            }
        }

        int count = Integer.MAX_VALUE;
        int maxi = -1;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) {
                    cnt++;
                }
            }
            if (cnt <= count) {
                count = cnt;
                maxi = i;
            }
        }


        return maxi;
    }
}
