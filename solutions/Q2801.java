import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Q2801 {
    int mod = 1000000007;
    ArrayList<Long> list = new ArrayList<>() {
        {
            addAll(List.of(0L, 9L, 17L, 32L, 61L, 116L));
            for (int i = 6; i < 100; i++) {
                add(((get(i - 1) + 4 * get(i - 2) - 3 * get(i - 3) - 3 * get(i - 4) + get(i - 5)) % 1000000007
                        + 1000000007) % 1000000007);
            }
        }
    };

    public int countSteppingNumbers(String low, String high) {
        return (countSteppingNumbers(high) - countSteppingNumbers("" + new BigInteger(low).subtract(BigInteger.ONE))
                + mod) % mod;
    }

    private int countSteppingNumbers(String s) {
        Integer count = 0, dp[][][] = new Integer[s.length()][10][2];
        for (int i = 1; i < s.length(); i++) {
            count = (count + list.get(i).intValue()) % mod;
        }
        for (int i = 1; i <= s.charAt(0) - '0'; i++) {
            count = (count + countSteppingNumbers(1, i, i < s.charAt(0) - '0', s, dp)) % mod;
        }
        return count;
    }

    private int countSteppingNumbers(int index, int prev, boolean flag, String s, Integer[][][] dp) {
        if (prev < 0 || prev > 9) {
            return 0;
        } else if (index == s.length()) {
            return 1;
        } else if (dp[index][prev][flag ? 1 : 0] == null) {
            dp[index][prev][flag ? 1 : 0] = ((!flag && prev >= s.charAt(index) - '0' ? 0
                    : countSteppingNumbers(index + 1, prev + 1, flag || prev + 1 < s.charAt(index) - '0', s, dp))
                    +
                    (!flag && prev - 1 > s.charAt(index) - '0' ? 0
                            : countSteppingNumbers(index + 1, prev - 1, flag || prev <= s.charAt(index) - '0', s, dp)))
                    % mod;
        }
        return dp[index][prev][flag ? 1 : 0];
    }
}
