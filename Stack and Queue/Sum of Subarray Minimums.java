import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] psee = findPSEE(arr);
        int[] nse = findNSE(arr);
        int total = 0;
        int mod = (int) (1e9 + 7);

        for (int i = 0; i < arr.length; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;
            total = (int) ((total + (right * left * 1L * arr[i]) % mod) % mod);
        }
        return total;
    }

    public int[] findPSEE(int[] arr) {
        int[] psee = new int[arr.length];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            psee[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return psee;
    }

    public int[] findNSE(int[] arr) {
        int[] nse = new int[arr.length];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);
        }
        return nse;
    }
}

// Time Complexity = O(5n)
// Space Complexity = O(5n)