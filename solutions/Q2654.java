public class Q2654 {

    public int minOperations(int[] nums) {

        int n = nums.length;

        int c = nums[n - 1] == 1 ? 1 : 0;
        int h = 0;
        int a = Integer.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            c += nums[i] == 1 ? 1 : 0;
            h += gcd(nums[i], nums[i + 1]) == 1 ? 1 : 0;
        }

        if (c + h > 0) {
            return n - c;
        }

        for (int i = 0; i < n - 1; i++) {
            int b = nums[i];
            for (int j = i + 1; j < n; j++) {
                if (gcd(b, nums[j]) == 1) {
                    a = Math.min(a, j - i + n - 1);
                }
                b = gcd(b, nums[j]);
            }
        }

        return a == Integer.MAX_VALUE ? -1 : a;
    }


    // easy way to find greatest common divisor!!! 
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
