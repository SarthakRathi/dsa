// Better

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Majority {
    public static void main(String[] args) {
        int[] nums = { 1 };

        Map<Integer, Integer> hash = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                hash.put(nums[i], hash.get(nums[i]) + 1);
            } else {
                hash.put(nums[i], 1);
            }
            if (hash.get(nums[i]) > nums.length / 3 && !answer.contains(nums[i])) {
                answer.add(nums[i]);
            }
        }

        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }
}

// Time Complexity = O(n)
// Space Complexity = O(n)