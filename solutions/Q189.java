public class Q189 {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;    // recourd the total number has changed
        for (int start = 0; count<nums.length; start++){
            int temp = nums[start];
            int cur = start;
            int prev = (cur - k + nums.length) % nums.length;
            while (prev != start){
                nums[cur] = nums[prev];
                cur = prev;
                prev = (cur - k + nums.length) % nums.length;
                count ++;
            }
            nums[cur] = temp;
            count++;
        }
    }
}
