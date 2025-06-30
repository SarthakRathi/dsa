class SingleElement {
    public static void main(String[] args) {
        int[] nums = { 7, 7, 10, 11, 11, 12, 12 };

        if (nums.length == 1) {
            System.out.println(nums[0]);
        } else {
            if (nums[0] != nums[1]) {
                System.out.println(nums[0]);
            }
            if (nums[nums.length - 2] != nums[nums.length - 1]) {
                System.out.println(nums[nums.length - 1]);
            }

            int low = 1;
            int high = nums.length - 2;
            while (low <= high) {
                int mid = (low + high) / 2;

                if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                    System.out.println(nums[mid]);
                }
                if (mid % 2 == 0) {
                    if (nums[mid] == nums[mid + 1]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                } else {
                    if (nums[mid] == nums[mid - 1]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
    }
}
