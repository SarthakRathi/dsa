// Optimal

class Colors {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        int temp;

        while (mid <= high) {
            if (nums[mid] == 0) {
                temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }

        for (int i : nums) {
            System.out.println(i);
        }
    }
}

// Time Complexity = O(n)
// Space Complexity = O(1)

// Better

// class Colors {
// public static void main(String[] args) {
// int[] nums = { 0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

// int count0 = 0;
// int count1 = 0;

// for (int i = 0; i < nums.length; i++) {
// if (nums[i] == 0) {
// count0++;
// } else if (nums[i] == 1) {
// count1++;
// }
// }

// for (int i = 0; i < count0; i++) {
// nums[i] = 0;
// }
// for (int i = count0; i < count0 + count1; i++) {
// nums[i] = 1;
// }
// for (int i = count0 + count1; i < nums.length; i++) {
// nums[i] = 2;
// }

// for (int i : nums) {
// System.out.println(i);
// }
// }
// }

// Time Complexity = O(2n)
// Space Complexity = O(1)
