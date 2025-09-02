import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }

        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();

        image[sr][sc] = color;
        q.add(new int[] { sr, sc });

        int[] dr = { 1, -1, 0, 0 };
        int[] dc = { 0, 0, 1, -1 };
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];

            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];

                if (newR >= 0 && newR < m && newC >= 0 && newC < n && image[newR][newC] == originalColor) {
                    image[newR][newC] = color;
                    q.add(new int[] { newR, newC });
                }
            }
        }
        return image;
    }
}