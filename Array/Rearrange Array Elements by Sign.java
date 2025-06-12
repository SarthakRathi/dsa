// Optimal

class Rearrange {
    public static void main(String[] args) {
        int[] nums = { 3, 1, -2, -5, 2, -4 };

        int[] ans = new int[nums.length];
        int pos = 0;
        int neg = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans[pos] = nums[i];
                pos += 2;
            } else {
                ans[neg] = nums[i];
                neg += 2;
            }
        }

        for (int i : ans) {
            System.out.println(i);
        }
    }
}

// Time Complexity = O(n)
// Space Complexity = O(n)