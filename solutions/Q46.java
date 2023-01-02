import java.util.ArrayList;
import java.util.List;

public class Q46 {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();
        int n = nums.length;
        for (int i=0; i<n; i++){
            temp.add(nums[i]);
        }
        backtrack(n, temp, 0);
        return results;
    }

    private void backtrack(int n, ArrayList<Integer> temp, int first){
        if (first == n){
            results.add(new ArrayList<>(temp));
            return;
        }
        for (int i=first; i<n; i++){
            // switch and backtrack
            int swap = temp.get(i);
            temp.set(i, temp.get(first));
            temp.set(first, swap);
            backtrack(n, temp, first+1);
            // switch back
            temp.set(first, temp.get(i));
            temp.set(i, swap);
        }
    }
}
