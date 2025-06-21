// Optimal

import java.util.ArrayList;
import java.util.List;

class Spiral {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = cols - 1;
        int top = 0;
        int bottom = rows - 1;

        List<Integer> ans = new ArrayList<>();

        while (top <= bottom && left <= right) {
            // right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                // left
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // top
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        for (Integer integer : ans) {
            System.out.println(integer);
        }
    }
}

// Time Complexity = O(n**2)
// Space Complexity = O(1)