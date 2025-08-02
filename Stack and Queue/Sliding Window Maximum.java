import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0)
            return new int[0];

        int n = nums.length;
        int[] res = new int[n - k + 1];
        int ind = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                res[ind++] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}

// Time Complexity = O(2n)
// Time Complexity = O(k) + O(n - k)