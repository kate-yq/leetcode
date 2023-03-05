import java.util.*;

public class Q6309 {
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        Set<Integer>[] divisors = new Set[n];
        Map<Integer, Integer> count = new HashMap<>();

        for (int i=0; i<n; i++){
            divisors[i] = findDivisor(nums[i]);
            for (int d : divisors[i]){
                count.put(d, (count.containsKey(d))? count.get(d)+1 : 1);
            }
        }

        Set<Integer> prefix = new HashSet<>();
        int sum = 0;

        for (int i=0; i<=n-2; i++){
            prefix.addAll(divisors[i]);
            for (int d : divisors[i]){
                count.put(d, count.get(d)-1);
                if (count.get(d) == 0){
                    sum++;
                }
            }
            if (prefix.size() == sum){
                return i;
            }
        }
        return -1;
    }

    private Set<Integer> findDivisor(int num){
        Set<Integer> divisor = new HashSet<>();
        for (int i = 2; i<= Math.pow(num, 0.5); i++){
            if (num % i == 0){
                divisor.add(i);
                divisor.add(num / i);
            }
        }
        divisor.add(num);
        return divisor;
    }
}
