import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Pascal {
    public static void main(String[] args) {
        int numRows = 5;

        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows > 0) {

            triangle.add(Arrays.asList(1));

            for (int i = 1; i < numRows; i++) {
                List<Integer> row = new ArrayList<>();
                List<Integer> prevRow = triangle.get(i - 1);

                row.add(1);

                for (int j = 1; j < i; j++) {
                    row.add(prevRow.get(j - 1) + prevRow.get(j));
                }

                row.add(1);

                triangle.add(row);
            }
        }
    }
}
