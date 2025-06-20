// Optimal

class Matrix {
    public static void main(String[] args) {
        // int matrix[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int matrix[][] = { { 0, 1 } };

        int rows = matrix.length;
        int cols = matrix[0].length;
        int col0 = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        if (col0 == 0) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
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

// Time Complexity = O(2nm)
// Space Complexity = O(1)

// Better

// class Matrix {
// public static void main(String[] args) {
// // int matrix[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
// int matrix[][] = { { 0, 1 } };

// int rows = matrix.length;
// int cols = matrix[0].length;

// boolean[] zeroRows = new boolean[rows];
// boolean[] zeroCols = new boolean[cols];

// for (int i = 0; i < rows; i++) {
// for (int j = 0; j < cols; j++) {
// if (matrix[i][j] == 0) {
// zeroRows[i] = true;
// zeroCols[j] = true;
// }
// }
// }

// for (int i = 0; i < rows; i++) {
// for (int j = 0; j < cols; j++) {
// if (zeroRows[i] || zeroCols[j]) {
// matrix[i][j] = 0;
// }
// }
// }

// for (int i = 0; i < rows; i++) {
// for (int j = 0; j < cols; j++) {
// System.out.print(matrix[i][j] + " ");
// }
// System.out.println();
// }
// }
// }

// Time Complexity = O(2nm)
// Space Complexity = O(n) + O(m)

// Bruteforce

// class Matrix {
// public static void main(String[] args) {
// // int matrix[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
// int matrix[][] = { { 0, 1 } };

// int rows = matrix.length;
// int cols = matrix[0].length;

// for (int i = 0; i < rows; i++) {
// for (int j = 0; j < cols; j++) {
// if (matrix[i][j] == 0) {
// for (int i2 = 0; i2 < rows; i2++) {
// if (matrix[i2][j] != 0) {
// matrix[i2][j] = -999;
// }
// }
// for (int j2 = 0; j2 < cols; j2++) {
// if (matrix[i][j2] != 0) {
// matrix[i][j2] = -999;
// }
// }
// }
// }
// }

// for (int i = 0; i < rows; i++) {
// for (int j = 0; j < cols; j++) {
// if (matrix[i][j] == -999) {
// matrix[i][j] = 0;
// }
// }
// }

// for (int i = 0; i < rows; i++) {
// for (int j = 0; j < cols; j++) {
// System.out.println(matrix[i][j]);
// }
// }
// }
// }

// Time Complexity = O(n**3)
// Space Complexity = O(1)