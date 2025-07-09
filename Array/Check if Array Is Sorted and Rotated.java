class CheckArraySorted {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 2, 1 };

        int peak = 0;

        if (nums[0] < nums[nums.length - 1])
            peak++;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                peak++;
            }
            if (peak > 1) {
                System.out.println("Array is not rotated");
                System.exit(0);
            }
        }
        System.out.println("Array is rotated");
    }
}
