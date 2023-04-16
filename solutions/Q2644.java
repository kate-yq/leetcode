public class Q2644 {
    public int maxDivScore(int[] nums, int[] divisors) {
        int hiScore = 0;
        int ans = divisors[0];
        for (int i = 0; i<divisors.length; i++){
            int cur = 0;
            for (int num : nums){
                if (num % divisors[i] == 0){
                    cur++;
                }
            }
            if (cur > hiScore){
                hiScore = cur;
                ans = divisors[i];
            } else if (cur == hiScore){
                ans = Math.min(ans, divisors[i]);
            }
        }
        return ans;
    }
}
