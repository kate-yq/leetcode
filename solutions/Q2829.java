import java.util.*;

public class Q2829 {
    public int minimumSum(int n, int k) {
        Set<Integer> set = new HashSet<>();

        int num = 1;
        int sum = 0;
        while (set.size() < n) {
            if (!set.contains(k - num)) {
                set.add(num);
                sum += num;
            }
            num++;
        }
        return sum;
    }
}
