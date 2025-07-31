import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int right = 0; right <= n; right++) {
            while (!stack.isEmpty()
                    && (right == n || nums[stack.peek()] >= (right < n ? nums[right] : Integer.MIN_VALUE))) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                long leftCount = mid - left;
                long rightCount = right - mid;
                answer -= (long) nums[mid] * leftCount * rightCount;
            }
            stack.push(right);
        }

        stack.clear();

        for (int right = 0; right <= n; right++) {
            while (!stack.isEmpty()
                    && (right == n || nums[stack.peek()] <= (right < n ? nums[right] : Integer.MAX_VALUE))) {
                int mid = stack.pop();
                int left = stack.isEmpty() ? -1 : stack.peek();
                long leftCount = mid - left;
                long rightCount = right - mid;
                answer += (long) nums[mid] * leftCount * rightCount;
            }
            stack.push(right);
        }

        return answer;
    }
}

// Time Complexity = O(n)
// Space Complexity = O(n)