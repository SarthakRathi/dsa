class BinarySearch {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 6, 7, 9, 12, 16, 17 };
        int target = 3;

        int low = 0;
        int high = nums.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                System.out.println("Element found at " + mid);
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
}

// Time Complexity = O(log n)