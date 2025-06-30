class FindMinimum {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };

        int lowest = nums[0];

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < lowest) {
                lowest = nums[mid];
            }

            if (nums[low] <= nums[mid]) {
                if (lowest > nums[low]) {
                    lowest = nums[low];
                }
                low = mid + 1;
            } else {
                if (lowest > nums[mid]) {
                    lowest = nums[mid];
                }
                high = mid - 1;
            }
        }

        System.out.println(lowest);
    }
}
