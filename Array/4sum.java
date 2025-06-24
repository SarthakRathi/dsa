// Optimal

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FSum {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 2, 2 };
        int target = 8;

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {

                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.addAll(List.of(nums[i], nums[j], nums[k], nums[l]));
                        ans.add(temp);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}

// Time Complexity = O(n**3)
// Space Complexity = O(1)

// Optimal

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.HashSet;
// import java.util.List;
// import java.util.Set;

// class FSum {
// public static void main(String[] args) {
// int[] nums = { 1, 0, -1, 0, -2, 2 };
// int target = 0;

// Set<List<Integer>> ans = new HashSet<>();

// for (int i = 0; i < nums.length; i++) {
// for (int j = i + 1; j < nums.length; j++) {
// Set<Integer> set = new HashSet<>();
// for (int k = j + 1; k < nums.length; k++) {
// int fourth = target - (nums[i] + nums[j] + nums[k]);

// if (set.contains(fourth)) {
// List<Integer> temp = new ArrayList<>();
// System.out.println("Adding : " + nums[i] + nums[j] + nums[k]);
// temp.addAll(List.of(nums[i], nums[j], nums[k], fourth));
// Collections.sort(temp);
// ans.add(temp);
// }
// set.add(nums[k]);
// }
// }
// }
// System.out.println(ans);
// }
// }

// Time Complexity = O(n**3)
// Space Complexity = O(n)
