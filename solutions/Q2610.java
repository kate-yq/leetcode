import java.util.*;

public class Q2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        List<List<Integer>> ans = new ArrayList<>();

        int remaining = count.size();
        while (remaining >0){
            List<Integer> row = new ArrayList<>();
            for (int i : count.keySet()){
                if (count.get(i) > 1){
                    count.put(i, count.get(i)-1);
                    row.add(i);
                } else if (count.get(i) == 1){
                    count.put(i, count.get(i)-1);
                    row.add(i);
                    remaining--;
                }
            }
            ans.add(new ArrayList<>(row));
        }
        return ans;
    }
}
