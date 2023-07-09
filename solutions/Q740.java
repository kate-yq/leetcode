import java.util.*;

class Q740 {
    HashMap<Integer, Integer> memo;

    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        this.memo = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
        }

        return calculate(map, map.firstKey());
    }

    private int calculate(TreeMap<Integer, Integer> map, Integer cur) {
        if (cur == null || cur > map.lastKey()) {
            return 0;
        }
        if (!map.containsKey(cur)) {
            return calculate(map, map.higherKey(cur));
        }

        if (memo.containsKey(cur)) {
            return memo.get(cur);
        }

        if (!map.containsKey(cur + 1)) {
            int res = calculate(map, map.higherKey(cur)) + map.get(cur);
            this.memo.put(cur, res);
            return res;
        }

        int choose = calculate(map, cur + 2) + map.get(cur);
        int notChoose = calculate(map, cur + 3) + map.get(cur + 1);

        memo.put(cur, Math.max(choose, notChoose));
        return memo.get(cur);
    }
}