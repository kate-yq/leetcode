import java.util.*;

public class Q2830 {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers, (a, b) -> {
            if (a.get(1) == b.get(1)) {
                return a.get(0) - b.get(0);
            }
            return a.get(1) - b.get(1);
        });

        int[] profit = new int[n + 1];
        int house = 1;
        for (List<Integer> o : offers) {
            int start = o.get(0) + 1;
            int end = o.get(1) + 1;
            int gold = o.get(2);
            while (house <= end) {
                profit[house] = Math.max(profit[house], profit[house - 1]);
                house++;
            }
            profit[end] = Math.max(profit[end], profit[start - 1] + gold);
        }

        return profit[house - 1];
    }
}
