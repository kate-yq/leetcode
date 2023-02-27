public class StringPattern {
    int MOD = (int) Math.pow(10, 9) + 7;

    // Power function to calculate
    // long powers with mod
    private long power(int x, int y) {
        long res = 1;
        x = x % MOD;

        if (x == 0){
            return 0;
        }

        while (y > 0) {
            res = res * x % MOD;
            y--;
        }
        return res;
    }

    // Function for finding number of ways to
    // create string with length N and atmost
    // K contiguous vowels
    public long kvowelwords(int len, int max) {
        int i, j;

        // Array dp to store number of ways
        long[][] dp = new long[len + 1][max + 1];

        long sum = 1;
        for (i = 1; i <= len; i++) {

            // dp[i][0] = (dp[i-1][0]+dp[i-1][1]..dp[i-1][k])*21
            dp[i][0] = sum * 21 % MOD;

            // Now setting sum to be dp[i][0]
            sum = dp[i][0];

            for (j = 1; j <= max; j++) {

                // If j>i, no ways are possible to create
                // a string with length i and vowel j
                if (j > i){
                    dp[i][j] = 0;
                } else if (j == i) {

                    // If j = i all the character should
                    // be vowel
                    dp[i][j] = power(5, i);
                } else {
                    // dp[i][j] relation with dp[i-1][j-1]
                    dp[i][j] = dp[i - 1][j - 1] * 5;
                }

                dp[i][j] %= MOD;

                // Adding dp[i][j] in the sum
                sum += dp[i][j];
                sum %= MOD;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        StringPattern n1 = new StringPattern();
        System.out.println(n1.kvowelwords(37, 20));
    }
}
