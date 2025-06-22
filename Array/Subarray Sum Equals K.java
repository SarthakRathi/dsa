//Brute: 2 loops

//Optimal

import java.util.HashMap;
import java.util.Map;

class SubarraySumEquals {
    public static void main(String[] args) {
        int[] nums = { -1, -1, 1 };
        int k = 0;

        Map<Integer, Integer> hash = new HashMap<>();
        int prefixsum = 0;
        int count = 0;

        hash.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            prefixsum = prefixsum + nums[i];

            if (hash.containsKey(prefixsum - k)) {
                count += hash.get(prefixsum - k);
            }

            if (!hash.containsKey(prefixsum)) {
                hash.put(prefixsum, 1);
            } else {
                int val = hash.get(prefixsum);
                hash.put(prefixsum, val + 1);
            }
        }

        System.out.println(count);
    }
}

// Time Complexity = O(n)
// Space Complexity = O(n)