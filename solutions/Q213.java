public class Q213 {
    public int rob(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int[] dp_rob_first = new int[nums.length];
        dp_rob_first[0] = nums[0];
        dp_rob_first[1] = nums[0];
        int[] dp_not_rob_first = new int[nums.length];
        dp_not_rob_first[0] = 0;
        dp_not_rob_first[1] = nums[1];
        for (int i = 2; i< nums.length-1; i++){
            dp_rob_first[i] = Math.max(dp_rob_first[i-1], nums[i]);
            dp_not_rob_first[i] = Math.max(dp_not_rob_first[i-1], nums[i]);
            for (int j=2; j<5 & j<=i; j++){
                dp_rob_first[i] = Math.max(dp_rob_first[i], dp_rob_first[i-j] + nums[i]);
                dp_not_rob_first[i] = Math.max(dp_not_rob_first[i], dp_not_rob_first[i-j] + nums[i]);
            }
        }

        // last step
        dp_rob_first[nums.length -1] = dp_rob_first[nums.length-2];

        dp_not_rob_first[nums.length - 1] = Math.max(dp_not_rob_first[nums.length - 2], nums[nums.length-1]);
        for (int j=2; j<5 & j<nums.length; j++){
            dp_not_rob_first[nums.length - 1] = Math.max(dp_not_rob_first[nums.length - 1], dp_not_rob_first[nums.length - 1-j] + nums[nums.length - 1]);
        }
        return Math.max(dp_rob_first[nums.length -1], dp_not_rob_first[nums.length -1]);
    }

    public static void main(String[] args){
        Q213 rb = new Q213();
        System.out.println(rb.rob(new int[]{1, 2, 3, 1}));
    }
}
