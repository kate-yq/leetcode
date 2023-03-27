import java.util.*;

public class Q2602 {
    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> ans = new ArrayList<>();

        Arrays.sort(nums);
        
        int n = nums.length;

        long[] prefixSum = new long[n+1];
        for (int i=1; i<=n; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i-1];
        }
        
        for (int j = 0; j<queries.length; j++){
            int index = binarySearch(nums, queries[j]);
            ans.add(index*(long) queries[j] - prefixSum[index] + prefixSum[n]-prefixSum[index] - (n-index)*(long) queries[j]);
        }
        return ans;
    }

    private int binarySearch(int[] nums, int target){
        // return the index with num>=target
        int left=0; 
        int right = nums.length;
        while (left < right-1){
            int mid = left + (right-left)/2;
            if (nums[mid] > target){
                right = mid;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        if (left >= nums.length || nums[left] >= target){
            return left;
        }
        return right;
    }
}
