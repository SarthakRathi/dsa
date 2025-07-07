class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 3;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[0][i] <= target && target <= matrix[i][matrix[i].length - 1]) {
                System.out.println(binarySearch(matrix[i], target));
                break;
            }
        }

    }

    public static boolean binarySearch(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}

// Time Complexity = O(n) + O(log m)
