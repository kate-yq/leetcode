public class Q2614 {
    public int diagonalPrime(int[][] nums) {
        int max = 0;
        int n = nums.length;

        for (int i = 0; i<n; i++){
            if (isPrime(nums[i][i])){
                max = Math.max(max, nums[i][i]);
            }
            if (isPrime(nums[i][n-i-1])){
                max = Math.max(max, nums[i][n-i-1]);
            }
        }

        return max;
    }

    private boolean isPrime(int num){
        if (num <= 1){
            return false;
        }
        for (int i = 2; i <= Math.pow(num, 0.5); i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
