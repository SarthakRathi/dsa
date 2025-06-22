// Optimal

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Sum {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(List.of(nums[i], nums[j], nums[k]));
                    ans.add(temp);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}

// Time Complexity = O(n**2)
// Space Complexity = O(1)

// Better

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;

// class Sum {
// public static void main(String[] args) {
// int[] nums = { -1, 0, 1, 2, -1, -4 };

// Set<List<Integer>> ans = new HashSet<>();

// for (int i = 0; i < nums.length; i++) {
// Set<Integer> set = new HashSet<>();
// for (int j = i + 1; j < nums.length; j++) {
// int third = -(nums[i] + nums[j]);

// if (set.contains(third)) {
// List<Integer> temp = new ArrayList<>();
// temp.addAll(List.of(nums[i], nums[j], third));
// Collections.sort(temp);
// ans.add(temp);
// }
// set.add(nums[j]);
// }
// }
// System.out.println(ans);
// }
// }

// Time Complexity = O(n**2)
// Space Complexity = O(n)
