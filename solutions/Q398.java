import java.util.*;

public class Q398 {
    HashMap<Integer, List<Integer>> indexs = new HashMap<>();
    Random rand = new Random();

    public Q398(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (!indexs.containsKey(nums[i])) {
                indexs.put(nums[i], new ArrayList<>());
            }
            indexs.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> in = indexs.get(target);
        int idx = rand.nextInt(in.size());

        return in.get(idx);
    }
}
