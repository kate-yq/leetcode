import java.util.HashMap;

public class Q169 {
    public int majorityElement(int[] nums) {
        int max = 1;
        int result = nums[0];
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if (freq.containsKey(nums[i])){
                freq.put(nums[i],freq.get(nums[i])+1);
                if (max < freq.get(nums[i])) {
                    max = freq.get(nums[i]);
                    result = nums[i];
                }
            } else {
                freq.put(nums[i], 1);
            }
        }
        return result;
    }
}
