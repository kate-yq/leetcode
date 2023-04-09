import java.util.ArrayList;
import java.util.HashMap;

public class Q2615 {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] ans = new long[n];

        HashMap<Integer, ArrayList<long[]>> indexs = new HashMap<>();
        for (int i = 0; i<n; i++){
            if (!indexs.containsKey(nums[i])){
                indexs.put(nums[i], new ArrayList<>());
                indexs.get(nums[i]).add(new long[]{i, i});
            } else {
                long prev = indexs.get(nums[i]).get(indexs.get(nums[i]).size()-1)[1];
                indexs.get(nums[i]).add(new long[]{i, i+prev});
            }
        }

        for (int i=0; i<n; i++){
            ArrayList<long[]> cur = indexs.get(nums[i]);
            
            int left = 0;
            int right = cur.size()-1;
            while (left < right){
                int mid = left + (right-left)/2;
                if (cur.get(mid)[0] < i){
                    left = mid+1;
                } else if (cur.get(mid)[0] > i){
                    right = mid-1;
                } else {
                    left = mid;
                    break;
                }
            }
            ans[i] = ((long)i) * (left + 1) - cur.get(left)[1] + cur.get(cur.size()-1)[1] - cur.get(left)[1] - ((long) i)* (cur.size() - left -1);

        }

        return ans;
    }
}
