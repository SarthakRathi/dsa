import java.util.PriorityQueue;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            } else {
                return b[1] - a[1];
            }
        });

        for (int i = 0; i < mat.length; i++) {
            int soldierCount = 0;
            for (int val : mat[i]) {
                if (val == 1)
                    soldierCount++;
                else
                    break;
            }

            maxHeap.offer(new int[] { soldierCount, i });

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll()[1];
        }

        return result;
    }
}