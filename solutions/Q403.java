import java.util.HashMap;
import java.util.HashSet;

class Q403 {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int stone : stones){
            map.put(stone, new HashSet<>());
        }

        map.get(0).add(0);

        for (int stone : stones) {
            for (int k : map.get(stone)) {
                // get all units to reach current stone
                // check if unit-1, unit, unit+1 can reach any stone
                for (int unit = k - 1; unit <= k + 1; unit++) {
                    if (unit > 0 && map.containsKey(stone + unit)) {
                        map.get(stone + unit).add(unit);
                    }
                }
            }
        }

        return !map.get(stones[stones.length-1]).isEmpty();
    }
}