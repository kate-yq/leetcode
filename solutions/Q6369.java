class Q6369{
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int[] sumL = new int[n];
        int[] sumR = new int[n];
        for (int i=1; i<n; i++){
            sumL[i] = sumL[i-1] + nums[i-1];
            sumR[n-i-1] = sumR[n-i] + nums[n-i];
        }
        int[] ans = new int[n];
        for (int i=0; i<n; i++){
            ans[i] = Math.abs(sumL[i] - sumR[i]);
        }
        return ans;
    }
}