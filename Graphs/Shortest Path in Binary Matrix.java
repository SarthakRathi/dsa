import java.util.ArrayDeque;
import java.util.Queue;

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
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        if (n == 1)
            return 1;

        Queue<Tuple> q = new ArrayDeque<>();
        q.add(new Tuple(1, 0, 0));

        int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

        while (!q.isEmpty()) {
            Tuple it = q.poll();
            int dis = it.distance;
            int r = it.row;
            int c = it.column;

            for (int i = 0; i < 8; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];

                if (newR >= 0 && newR < n && newC >= 0 && newC < n && grid[newR][newC] == 0) {
                    if (newR == n - 1 && newC == n - 1)
                        return dis + 1;
                    grid[newR][newC] = 1;
                    q.add(new Tuple(dis + 1, newR, newC));
                }
            }
        }
        return -1;
    }
}