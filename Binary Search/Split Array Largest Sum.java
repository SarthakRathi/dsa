class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8 };
        int k = 2;

        int low = max(nums);
        int high = sum(nums);
        int ans = high;
        boolean isPossible;

        while (high >= low) {
            int mid = (low + high) / 2;
            isPossible = isPossible(nums, mid, k);
            if (isPossible) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }

    public static int max(int[] nums) {
        int max = nums[0];
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static int sum(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        return sum;
    }

    public static boolean isPossible(int[] nums, int maxSum, int k) {
        int subarraysNeeded = 1;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (currentSum + nums[i] <= maxSum) {
                currentSum += nums[i];
            } else {
                subarraysNeeded++;
                currentSum = nums[i];
            }
        }
        return subarraysNeeded <= k;
    }
}

// Time Complexity = O(log2 sum) * n