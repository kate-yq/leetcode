import java.util.Arrays;

public class Q910 {
    public int smallestRangeII(int[] nums, int k) {
        if (nums.length == 1){
            return 0;
        }
        Arrays.sort(nums);
        int ans = nums[nums.length-1] - nums[0];
        for (int i=0; i<nums.length-1; i++){
            int high = Math.max(nums[nums.length-1]-k, nums[i]+k);
            int low = Math.min(nums[0]+k, nums[i+1]-k);
            ans = Math.min(ans, high-low);
        }
        return ans;
    }
}
