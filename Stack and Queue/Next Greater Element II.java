import java.util.ArrayDeque;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            if (i < n) {
                ans[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i % n]);
        }
        return ans;
    }
}

// Time Complexity = O(4n)
// Time Complexity = O(3n)