import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q216 {
    List<List<Integer>> results;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.results = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        backtrack(k, n, temp, 1);
        return results;
    }

    private void backtrack(int k, int n, LinkedList<Integer> temp, int start){
        if (k == 0 && n == 0){
            results.add(new ArrayList<>(temp));
        } else if (k<=0 || n<=0){
            return;
        }
        for (int i=start; i<10; i++){
            temp.add(i);
            backtrack(k-1, n-i, temp, i+1);
            temp.removeLast();
        }
    }
}
