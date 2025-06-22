// Better

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Majority {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 3, 3, 2, 2, 2 };

        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                hash.put(nums[i], hash.get(nums[i]) + 1);
            } else {
                hash.put(nums[i], 1);
            }
        }

        List<Integer> answer = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                answer.add(entry.getKey());
            }
        }

        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }
}

// Time Complexity = O(n)
// Space Complexity = O(n)