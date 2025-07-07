// Optimal

class Search2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        int target = 5;

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                System.out.println(row + " " + col);
                break;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
    }
}

// Time Complexity = O(n + m)

// Better

// class Search2DMatrixII {
// public static void main(String[] args) {
// int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16,
// 22 }, { 10, 13, 14, 17, 24 },
// { 18, 21, 23, 26, 30 } };
// int target = 5;

// for (int i = 0; i < matrix.length; i++) {
// if (matrix[i][0] <= target && target <= matrix[i][matrix[i].length - 1]) {
// System.out.println(binarySearch(matrix[i], target));
// }
// }
// }

// public static boolean binarySearch(int nums[], int target) {
// int low = 0;
// int high = nums.length - 1;
// while (high >= low) {
// int mid = (low + high) / 2;
// if (nums[mid] == target) {
// return true;
// } else if (nums[mid] < target) {
// low = mid + 1;
// } else {
// high = mid - 1;
// }
// }
// return false;
// }
// }

// Time Complexity = O(n * log m)