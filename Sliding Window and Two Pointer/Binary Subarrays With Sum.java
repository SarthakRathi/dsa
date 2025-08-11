class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return sliding(nums, goal) - sliding(nums, goal - 1);
    }

    public int sliding(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }

        int l = 0;
        int r = 0;
        int count = 0;
        int sum = 0;

        while (r < nums.length) {
            if (nums[r] == 1)
                sum++;
            while (sum > goal) {
                if (nums[l] == 1)
                    sum--;
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)