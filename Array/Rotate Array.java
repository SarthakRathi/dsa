// Optimal Approach
class Shifting {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 4, 5 };
        int k = 2;

        if (k > nums.length) {
            k = k % nums.length;
        }

        if (nums.length > 1 && k != 0) {
            nums = Shifting.reverse(nums, 0, nums.length - k - 1);
            Shifting.print(nums);
            nums = Shifting.reverse(nums, nums.length - k, nums.length - 1);
            Shifting.print(nums);
            nums = Shifting.reverse(nums, 0, nums.length - 1);
            Shifting.print(nums);
        }
    }

    public static int[] reverse(int nums[], int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

        return nums;
    }

    public static void print(int nums[]) {
        for (int i : nums) {
            System.out.print(i);
        }
        System.out.println();
    }
}

// 2nd bruteforce approach

// Reversing and adding plan cancel because java does not support adding them so
// logic would be too much

// Bruteforce Approach

// class Shift {
// public static void main(String[] args) {
// int[] nums = { 1, 2 };
// int k = 3;

// if (nums.length > 1) {
// int[] temp = new int[k];

// if (k > nums.length) {
// k = k % nums.length;
// }

// for (int i = k; i > 0; i--) {
// temp[k - i] = nums[nums.length - i];
// }

// for (int i = nums.length - k - 1; i >= 0; i--) {
// nums[i + k] = nums[i];
// }

// for (int i = 0; i < k; i++) {
// nums[i] = temp[i];
// }
// }

// for (int i : nums) {
// System.out.print(i);
// }
// }
// }

// Time Complexity: O(n + k)
// Space Complexity: O(k)