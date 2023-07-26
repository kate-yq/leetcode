import java.util.*;

public class Q2790 {
    public int maxIncreasingGroups(List<Integer> usageLimits) {

        // 二分法检查对于当前数量的小组是否能够达成
        // count是对于数的需求，从大到小的组分别填从多到少的数
        // 如果数不够的话可以用下一个补充，但是不能超过当前count，否则会导致同一组里插入相同的数

        Collections.sort(usageLimits);
        int left = 1, right = usageLimits.size();

        while (left < right) {
            int mid = (left + right + 1) / 2, count = 0;
            for (int i = 0; i < usageLimits.size(); i++) {
                count += Math.max(0, mid - i);
                count -= Math.min(count, usageLimits.get(usageLimits.size() - i - 1));
            }
            if (count == 0) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
