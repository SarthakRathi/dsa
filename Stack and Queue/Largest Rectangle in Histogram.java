import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
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
}

// Time Complexity = O(2n)
// Time Complexity = O(n)