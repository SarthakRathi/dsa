import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return sliding(nums, k) - sliding(nums, k - 1);
    }

    public int sliding(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        int l = 0;
        int r = 0;
        int count = 0;
        Map<Integer, Integer> hash = new HashMap<>();

        while (r < nums.length) {
            hash.put(nums[r], hash.getOrDefault(nums[r], 0) + 1);
            while (hash.size() > k) {
                if (hash.get(nums[l]) == 1) {
                    hash.remove(nums[l]);
                } else {
                    hash.put(nums[l], hash.get(nums[l]) - 1);
                }
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}

// Time Complexity = O(n)
// Space Complexity = O(n)