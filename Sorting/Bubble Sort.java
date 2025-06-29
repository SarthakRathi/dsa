class BubbleSort {
    public static void main(String[] args) {
        int[] nums = { 13, 46, 24, 52, 20, 9 };

        for (int j = nums.length - 1; j >= 1; j--) {
            int didSwap = 0;
            for (int i = 0; i <= j - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
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
}

// Time Complexity = O(n**2)