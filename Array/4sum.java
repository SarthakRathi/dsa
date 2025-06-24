// Optimal

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class FSum {
    public static void main(String[] args) {
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;

        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = j + 1; k < nums.length; k++) {
                    int fourth = target - (nums[i] + nums[j] + nums[k]);

                    if (set.contains(fourth)) {
                        List<Integer> temp = new ArrayList<>();
                        System.out.println("Adding : " + nums[i] + nums[j] + nums[k]);
                        temp.addAll(List.of(nums[i], nums[j], nums[k], fourth));
                        Collections.sort(temp);
                        ans.add(temp);
                    }
                    set.add(nums[k]);
                }
            }
        }
        System.out.println(ans);
    }
}

// Time Complexity = O(n**3)
// Space Complexity = O(n)
