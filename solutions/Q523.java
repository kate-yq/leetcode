import java.util.HashMap;

public class Q523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        int sum = 0;
        for (int i=0; i<nums.length; i++){
            sum += nums[i];
            prefixSum[i] = sum;
        }
        HashMap<Integer, Integer> remainder = new HashMap<>();
        remainder.put(0, -1);
        for (int i=0; i<nums.length; i++){
            if (remainder.containsKey(prefixSum[i]%k)){
                if ((i-remainder.get(prefixSum[i]%k))>=2){
                    return true;
                }
            } else {
                remainder.put(prefixSum[i]%k, i);
            }
        }
        return false;
    }
}
