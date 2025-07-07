class FindPeakElementII {
    public static void main(String[] args) {
        int[][] mat = { { 1, 4 }, { 3, 2 } };

        int m = mat.length;

        int low = 0;
        int high = m - 1;

        while (high >= low) {
            int midRow = (low + high) / 2;
            int maxCol = findMaxInRow(mat[midRow]);

            boolean isTopSmaller = (midRow == 0) || (mat[midRow - 1][maxCol] < mat[midRow][maxCol]);
            boolean isBottomSmaller = (midRow == m - 1) || (mat[midRow + 1][maxCol] < mat[midRow][maxCol]);

            if (isTopSmaller && isBottomSmaller) {
                System.out.println(midRow + " " + maxCol);
                break;
            } else if (!isTopSmaller) {
                high = midRow - 1;
            } else {
                low = midRow + 1;
            }
        }
    }

    public static int findMaxInRow(int[] row) {
        int maxIndex = 0;
        for (int i = 1; i < row.length; i++) {
            if (row[i] > row[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}

// Time Complexity = O(log2m * m)