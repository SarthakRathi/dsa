import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int total = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] heights = buildHeights(matrix, rows, cols);

        for (int i = 0; i < rows; i++) {
            total = Math.max(total, largestRectangleArea(heights[i]));
        }

        return total;
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        int total = 0;

        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int element = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                total = Math.max(total, heights[element] * (nse - pse - 1));
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int element = st.pop();
            int nse = heights.length;
            int pse = st.isEmpty() ? -1 : st.peek();
            total = Math.max(total, heights[element] * (nse - pse - 1));
        }

        return total;
    }

    public int[][] buildHeights(char[][] matrix, int rows, int cols) {
        int[][] heights = new int[rows][cols];

        for (int i = 0; i < cols; i++) {
            int count = 0;
            for (int j = 0; j < rows; j++) {
                if (matrix[j][i] == '1')
                    count++;
                else
                    count = 0;
                heights[j][i] = count;
            }
        }

        return heights;
    }
}

// Time Complexity = O(n * m) + O(n * 2m)
// Space Complexity = O(n * m) + O(n)