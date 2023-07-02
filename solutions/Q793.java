public class Q793 {
    public int preimageSizeFZF(int k) {

        long left = findLeftBond(k);
        long right = findLeftBond(k + 1);

        return (int) (right - left);
    }

    public long trailingZeroes(long n) {
        long divisor = 5;
        long ans = 0;

        while (n >= divisor) {
            ans += n / divisor;
            divisor *= 5;
        }

        return ans;
    }

    private long findLeftBond(int k) {
        long hi = Long.MAX_VALUE;
        long lo = 0;
        while (hi > lo) {
            long mid = lo + (hi - lo) / 2;

            if (trailingZeroes(mid) < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}
