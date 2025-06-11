// Better

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 2, 6, 5, 8, 11 };
        int target = 14;

        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i])) {
                System.out.printf("[%d,%d]", i, hash.get(target - nums[i]));
            } else {
                hash.put(nums[i], i);
            }
        }
    }
}

// Time Complexity: O(n*2)
// Space Complexity: O(n)

// Bruteforce

// class TwoSum {
// public static void main(String[] args) {
// int[] nums = { 2, 6, 5, 8, 11 };
// int target = 14;

// for (int i = 0; i < nums.length; i++) {
// for (int j = i + 1; j < nums.length; j++) {
// if (nums[i] + nums[j] == target) {
// System.out.printf("[%d,%d]", i, j);
// break;
// }
// }
// }
// }
// }

// // Time Complexity: O(n*2)
// // Space Complexity: O(1)
