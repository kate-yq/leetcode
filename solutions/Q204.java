import java.util.Arrays;

public class Q204 {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int ans = 0;
        for (boolean b : isPrime) {
            if (b) {
                ans++;
            }
        }

        return ans;
    }
}
