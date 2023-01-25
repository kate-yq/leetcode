import java.util.HashMap;

public class Q974 {
    public int subarraysDivByK(int[] nums, int k) {
        int presum = 0;
        // remain - count
        HashMap<Integer, Integer> remains = new HashMap<>();
        remains.put(0,1);
        for (int i=0; i<nums.length; i++){
            presum += nums[i];
            int remain = presum % k;
            if (remain < 0) {
                remain += k;
            }
            if (remains.containsKey(remain)){
                remains.put(remain, remains.get(remain)+1);
            } else {
                remains.put(remain, 1);
            }
        }
        int ans = 0;
        for (int i : remains.keySet()){
            ans = ans + remains.get(i) * (remains.get(i)-1) / 2;
        }
        return ans;
    }
}
