// Optimal

import java.util.ArrayList;
import java.util.List;

class Majority {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3, 3, 3 };

        List<Integer> answer = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int element1 = Integer.MIN_VALUE;
        int element2 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && element2 != nums[i]) {
                count1 = 1;
                element1 = nums[i];
            } else if (count2 == 0 && element1 != nums[i]) {
                count2 = 1;
                element2 = nums[i];
            } else if (nums[i] == element1) {
                count1++;
            } else if (nums[i] == element2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element1) {
                count1++;
            }
            if (nums[i] == element2) {
                count2++;
            }
        }
        int min = nums.length / 3;
        if (count1 > min) {
            answer.add(element1);
        }
        if (count2 > min) {
            answer.add(element2);
        }

        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)

// Better

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// class Majority {
// public static void main(String[] args) {
// int[] nums = { 1 };

// Map<Integer, Integer> hash = new HashMap<>();
// List<Integer> answer = new ArrayList<>();

// for (int i = 0; i < nums.length; i++) {
// if (hash.containsKey(nums[i])) {
// hash.put(nums[i], hash.get(nums[i]) + 1);
// } else {
// hash.put(nums[i], 1);
// }
// if (hash.get(nums[i]) > nums.length / 3 && !answer.contains(nums[i])) {
// answer.add(nums[i]);
// }
// }

// for (Integer integer : answer) {
// System.out.println(integer);
// }
// }
// }

// Time Complexity = O(n)
// Space Complexity = O(n)