import java.util.*;

public class Q2836 {
    public long getMaxFunctionValue(List<Integer> receiver, long k) {
        // Binary Lifting Technique:
        // The core of the solution lies in the binary lifting technique implemented in
        // the code. Binary lifting is a common technique used in algorithmic
        // problem-solving to efficiently traverse a tree or perform calculations
        // involving powers of two.

        // Precomputation of Jumps and Sums:
        // In the provided code, the jump array stores the information of players that
        // can be reached in a power of 2 steps. The sum array stores the cumulative sum
        // of player IDs up to that point. This precomputation allows us to efficiently
        // calculate the function value for different values of k using the binary
        // representation of k.

        // Calculating Function Value:
        // The loop that iterates through the bits of k (from the least significant bit
        // to the most significant bit) makes use of the binary lifting technique. If
        // the j-th bit of k is set, it means we need to consider the 2^j-th jump for
        // the calculation. We accumulate the sum of IDs using the sum array and update
        // the current player to the 2^j-th jump using the jump array.

        // Maximizing the Result:
        // For each starting player i, the code calculates the function value using the
        // binary lifting technique and keeps track of the maximum value seen so far
        // (res). The final result returned is the maximum value among all starting
        // players.

        // Handling the Problem Constraints:
        // The choice of using 32 iterations for the loop is based on the constraint
        // that the value of k is at most 1000. Since 2^32 is much larger than 1000,
        // this ensures that the code can handle the maximum value of k efficiently.

        int n = receiver.size();

        int[][] jump = new int[n][34];
        long[][] sum = new long[n][34];

        for (int i = 0; i < receiver.size(); i++) {
            jump[i][0] = receiver.get(i);
            sum[i][0] = i;
        }

        for (int j = 1; j < 34; j++) {
            for (int i = 0; i < n; i++) {
                jump[i][j] = jump[jump[i][j - 1]][j - 1];
                sum[i][j] = sum[i][j - 1] + sum[jump[i][j - 1]][j - 1];
            }
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            long m = 0;
            int cur = i;
            for (int j = 0; j < 34; j++) {
                if ((k & 1L << j) > 0) {
                    m += sum[cur][j];
                    cur = jump[cur][j];
                }
            }
            m += cur;
            res = Math.max(res, m);
        }
        return res;
    }
}
