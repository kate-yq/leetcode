import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q40 {
    List<List<Integer>> result;
    int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.result = new ArrayList<>();
        LinkedList<Integer> combination = new LinkedList<>();
        Arrays.sort(candidates);
        this.candidates = candidates;

        backtrack(target, 0, combination);
        return result;
    }

    private void backtrack(int remain, int start, LinkedList<Integer> combination){
        if (remain < 0){
            return;
        }
        if (remain == 0){
            this.result.add(new ArrayList<>(combination));
            return;
        }

        for (int i=start; i<this.candidates.length; i++){
            if (i>start && this.candidates[i]==this.candidates[i-1]){
                continue;
            }
            combination.add(this.candidates[i]);
            backtrack(remain-this.candidates[i], i+1, combination);
            combination.removeLast();
        }
        return;
    }
}
