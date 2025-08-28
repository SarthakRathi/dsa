import java.util.PriorityQueue;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[] { matrix[i][0], i, 0 });
        }

        int[] element = null;
        for (int i = 0; i < k; i++) {
            element = minHeap.poll();
            int row = element[1];
            int col = element[2];

            if (col + 1 < n) {
                minHeap.offer(new int[] { matrix[row][col + 1], row, col + 1 });
            }
        }
        return element[0];
    }
}