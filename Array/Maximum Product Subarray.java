//Optimal

class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };

        int prefix = 1;
        int suffix = 1;
        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;

            prefix *= nums[i];
            suffix *= nums[nums.length - i - 1];

            maximum = Integer.max(maximum, Integer.max(prefix, suffix));
        }
        System.out.println(maximum);
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)
