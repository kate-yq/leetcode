import java.util.HashSet;

public class Q128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length <=1){
            return nums.length;
        }
        
        HashSet<Integer> num_set = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            num_set.add(nums[i]);
        }

        int max_len = 1;
        for (int num : num_set){
            // make sure we are checking from the left starting point
            if (!num_set.contains(num-1)){
                int cur_num = num;
                int cur_len = 1;

                while (num_set.contains(cur_num+1)){
                    cur_num++;
                    cur_len++;
                }

                max_len = Math.max(max_len, cur_len);
            }
        }
        return max_len;
    }
}
