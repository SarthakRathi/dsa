// Brute

class Rotate {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] cmatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cmatrix[j][cols - 1 - i] = matrix[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(cmatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Time Complexity = O(n)
// Space Complexity = O(n)