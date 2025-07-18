import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        findSubsets(0, nums, ans, new ArrayList<>());
        return ans;
    }

    private void findSubsets(int ind, int[] nums, List<List<Integer>> ans, List<Integer> ds) {
        ans.add(new ArrayList<>(ds));
        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1])
                continue;

            ds.add(nums[i]);
            findSubsets(i + 1, nums, ans, ds);
            ds.remove(ds.size() - 1);
        }
    }
}

// Time Complexity = O(2^n * n)
// Space Complexity = O(2^n) * O(average space)