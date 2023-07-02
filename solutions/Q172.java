public class Q172 {
    public int trailingZeroes(int n) {
        int divisor = 5;
        int ans = 0;

        while (n >= divisor) {
            ans += n / divisor;
            divisor *= 5;
        }

        return ans;
    }
}
