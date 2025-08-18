class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        int last = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > max)
                return false;
            max = Math.max(max, nums[i] + i);
            if (max >= last) {
                return true;
            }
        }
        return true;
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)