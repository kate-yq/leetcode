import java.util.Arrays;

public class Q300 {
    public int lengthOfLIS(int[] nums){
        if (nums.length < 2){
            return nums.length;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i<dp.length; i++){
            for (int j = 0; j<i; j++){
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args){
        int[] test_case_1 = {0, 1, 0, 3, 2, 3};
        int[] test_case_2 = {10, 9, 2, 5, 3, 7, 101, 18};
        Q300 lLIS = new Q300();
        System.out.println(lLIS.lengthOfLIS(test_case_1));
        System.out.println(lLIS.lengthOfLIS(test_case_2));
    }
}
