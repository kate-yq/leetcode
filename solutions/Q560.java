import java.util.HashMap;

public class Q560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> pre_sum = new HashMap<>();
        pre_sum.put(0,1);
        int sum = 0;
        int result = 0;
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            if (pre_sum.containsKey(sum-k)){
                result += pre_sum.get(sum-k);
            }
            if (pre_sum.containsKey(sum)){
                pre_sum.put(sum, pre_sum.get(sum)+1);
            } else {
                pre_sum.put(sum, 1);
            }
        }
        return result;
    }
}
