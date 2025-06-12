// Optimal

class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = { -2, -3, 4, -1, -2, 1, 5, -3 };

        int maximum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (sum > maximum) {
                maximum = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println(maximum);
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)