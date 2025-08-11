class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return sliding(nums, k) - sliding(nums, k - 1);
    }

    public int sliding(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        int l = 0;
        int r = 0;
        int count = 0;
        int sum = 0;

        while (r < nums.length) {
            sum += nums[r] & 1;
            while (sum > k) {
                sum -= nums[l] & 1;
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