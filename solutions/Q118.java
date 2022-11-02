import java.util.List;
import java.util.ArrayList;

public class Q118 {
    public List<List<Integer>> generate(int numRows) {

        // base-case: when numRows == 1
        if (numRows == 1) {
            List<Integer> row_1 = new ArrayList<>();
            row_1.add(1);
            List<List<Integer>> triangle = new ArrayList<>();
            triangle.add(row_1);
            return triangle;
        }

        List<Integer> cur_row = new ArrayList<>();
        List<List<Integer>> prev_triangle = new ArrayList<>(generate(numRows - 1));
        List<Integer> up_row = new ArrayList<>(prev_triangle.get(numRows - 2));
        cur_row.add(1);
        for (int i = 1; i < numRows - 1; i++) {
            cur_row.add(up_row.get(i - 1) + up_row.get(i));
        }
        cur_row.add(1);
        prev_triangle.add(cur_row);
        return prev_triangle;
    }
}
