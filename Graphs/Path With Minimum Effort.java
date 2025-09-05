import java.util.PriorityQueue;

class Tuple {
    int distance;
    int row;
    int column;

    Tuple(int distance, int row, int column) {
        this.distance = distance;
        this.row = row;
        this.column = column;
    }
}

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Tuple> q = new PriorityQueue<>((x, y) -> x.distance - y.distance);

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) (1e9);
            }
        }
        dist[0][0] = 0;
        q.add(new Tuple(0, 0, 0));

        int[] dr = { 1, -1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };

        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int dis = it.distance;
            int r = it.row;
            int c = it.column;

            if (r == n - 1 && c == m - 1) {
                return dis;
            }

            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];

                if (newR >= 0 && newR < n && newC >= 0 && newC < m) {
                    int effort = Math.max(Math.abs(heights[r][c] - heights[newR][newC]), dis);
                    if (effort < dist[newR][newC]) {
                        dist[newR][newC] = effort;
                        q.add(new Tuple(effort, newR, newC));
                    }
                }
            }
        }
        return 0;
    }
}