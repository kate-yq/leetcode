import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q47 {
    List<List<Integer>> results;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.results = new ArrayList<>();

        // count the occurrence of each number
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            if (!counter.containsKey(num))
                counter.put(num, 0);
            counter.put(num, counter.get(num) + 1);
        }

        // instead of switch, we build the permutation from 0
        List<Integer> comb = new ArrayList<>();
        this.backtrack(comb, nums.length, counter);
        return results;
    }

    private void backtrack(List<Integer> comb, Integer N, HashMap<Integer, Integer> counter) {
        if (comb.size() == N) {
            // make a deep copy of the resulting permutation,
            // since the permutation would be backtracked later.
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (int num : counter.keySet()) {
            // get a unique number and see how many of this num is left
            Integer count = counter.get(num);
            if (count == 0){
                continue;
            }
            // add this number into the current combination
            comb.add(num);
            counter.put(num, count - 1);

            // continue the exploration
            backtrack(comb, N, counter);

            // revert the choice for the next loop
            comb.remove(comb.size()-1);
            counter.put(num, count);
        }
    }
}
