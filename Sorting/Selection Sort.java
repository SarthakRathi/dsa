class Selection {
    public static void main(String[] args) {
        int[] nums = { 13, 46, 24, 52, 20, 9 };

        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i; j <= nums.length - 1; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }

        for (int i : nums) {
            System.out.println(i);
        }
    }
}
