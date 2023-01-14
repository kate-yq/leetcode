import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q77 {
    List<List<Integer>> results;

    public List<List<Integer>> combine(int n, int k) {
        results = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        backtrack(n, k, 1, temp);
        return results;
    }

    private void backtrack(int n, int k, int start, LinkedList<Integer> temp){
        if (k == 0){
            results.add(new ArrayList<>(temp));
            return;
        }
        if (start > n){
            return;
        }
        for (int i=start; i<=n; i++){
            temp.add(i);
            backtrack(n, k-1, i+1, temp);
            temp.removeLast();
        }
    }
}
