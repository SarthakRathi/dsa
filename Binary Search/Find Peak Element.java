class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };

        if (nums.length == 1) {
            System.out.println(0);
        } else if (nums[0] > nums[1]) {
            System.out.println(0);
        } else if (nums[nums.length - 1] > nums[nums.length - 2]) {
            System.out.println(nums.length - 1);
        } else {
            int low = 1;
            int high = nums.length - 2;

            while (high >= low) {
                int mid = (low + high) / 2;
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    System.out.println(mid);
                    break;
                } else if (nums[mid] > nums[mid - 1]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
    }
}
