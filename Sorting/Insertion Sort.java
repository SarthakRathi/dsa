class InsertionSort {
    public static void main(String[] args) {
        int[] nums = { 13, 46, 24, 52, 20, 9 };

        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                swap(j, nums);
                j--;
            }
        }

        for (int i : nums) {
            System.out.println(i);
        }
    }

    public static void swap(int j, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[j - 1];
        nums[j - 1] = temp;
    }
}

// Time Complexity = O(n**2)