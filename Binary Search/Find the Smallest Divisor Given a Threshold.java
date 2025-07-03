class SmallestDivisor {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 9 };
        int threshold = 6;

        int low = 1;
        int high = max(nums);
        int ans = high;
        boolean isPossible;

        while (high >= low) {
            int mid = (low + high) / 2;
            isPossible = isPossible(nums, mid, threshold);
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

    public static boolean isPossible(int[] nums, int divisor, int threshold) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            counter += Math.ceil((double) nums[i] / divisor);
        }
        return counter <= threshold;
    }
}

// Time Complexity = O(log2 max) * n