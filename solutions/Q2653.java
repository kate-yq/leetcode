import java.util.TreeMap;

public class Q2653 {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans  = new int[n-k+1];

        TreeMap<Integer, Integer> freq = new TreeMap<>();

        for (int i=0; i<k-1; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
        }
        
        for (int i = k-1; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
            int sum =0;
            for (int num: freq.keySet()){
                sum+= freq.get(num);
                if (sum >= x || num >=0){
                    ans[i-k+1] = Math.min(num, 0);
                    break;
                }
            }
            freq.put(nums[i-k+1], freq.get(nums[i-k+1])-1);
        }

        return ans;
    }
}
