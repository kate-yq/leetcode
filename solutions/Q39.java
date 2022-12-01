import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q39 {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target){
        this.result = new ArrayList<>();
        LinkedList<Integer> combination = new LinkedList<>();

        backtrack(target, 0, candidates, combination);
        return result;
    }

    private void backtrack(int remain, int start, int[] candidates, LinkedList<Integer> combination){
        if (remain < 0){
            return;
        }
        if (remain == 0){
            this.result.add(new ArrayList<Integer>(combination));
            return;
        }

        for (int i=start; i<candidates.length; i++){
            combination.add(candidates[i]);
            backtrack(remain-candidates[i], i, candidates, combination);
            combination.removeLast();
        }
        return;
    }
}
