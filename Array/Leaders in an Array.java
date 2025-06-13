// Optimal

import java.util.ArrayList;
import java.util.List;

class Array {
    public static void main(String[] args) {
        int[] nums = { 10, 22, 12, 3, 0, 6 };

        List<Integer> max = new ArrayList<>();
        int maximum = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > maximum) {
                maximum = nums[i];
                max.add(nums[i]);
            }
        }

        System.out.println(max);
    }
}

// Time Complexity = O(n)
// Space Complexity = O(n)