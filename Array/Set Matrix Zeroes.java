// Bruteforce

class Matrix {
    public static void main(String[] args) {
        // int matrix[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int matrix[][] = { { 0, 1 } };

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    for (int i2 = 0; i2 < rows; i2++) {
                        if (matrix[i2][j] != 0) {
                            matrix[i2][j] = -999;
                        }
                    }
                    for (int j2 = 0; j2 < cols; j2++) {
                        if (matrix[i][j2] != 0) {
                            matrix[i][j2] = -999;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == -999) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }
}

// Time Complexity = O(n**3)
// Space Complexity = O(1)