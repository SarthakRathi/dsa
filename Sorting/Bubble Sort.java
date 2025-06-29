class BubbleSort {
    public static void main(String[] args) {
        int[] nums = { 13, 46, 24, 52, 20, 9 };

        for (int i = nums.length - 1; i >= 1; i--) {
            int didSwap = 0;
            for (int j = 0; j <= i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(j, nums);
                    didSwap = 1;
                }
            }
            if (didSwap == 0) {
                break;
            }
        }

        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void swap(int j, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[j + 1];
        nums[j + 1] = temp;
    }
}

// Time Complexity = O(n**2)