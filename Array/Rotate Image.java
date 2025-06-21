// Optimal

class Rotate {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        int rows = matrix.length;
        int cols = matrix[0].length;
        int temp;

        for (int i = 0; i < rows; i++) {
            for (int j = i + 1; j < cols; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < rows; i++) {
            int start = 0;
            int end = cols - 1;
            while (start <= end) {
                temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Time Complexity = O(n**2)
// Space Complexity = O(1)

// Brute

// class Rotate {
// public static void main(String[] args) {
// int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

// int rows = matrix.length;
// int cols = matrix[0].length;

// int[][] cmatrix = new int[rows][cols];

// for (int i = 0; i < rows; i++) {
// for (int j = 0; j < cols; j++) {
// cmatrix[j][cols - 1 - i] = matrix[i][j];
// }
// }

// for (int i = 0; i < rows; i++) {
// for (int j = 0; j < cols; j++) {
// System.out.print(cmatrix[i][j] + " ");
// }
// System.out.println();
// }
// }
// }

// Time Complexity = O(n**2)
// Space Complexity = O(n**2)