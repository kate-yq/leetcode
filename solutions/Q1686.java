import java.util.Arrays;

class Q1686 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        // value the stone based on a[i]+b[i]
        // if the stone is supervalue to alice, alice want to take it
        // if the stone is supervalue to bob, alice want to take it

        int n = aliceValues.length;
        int[][] sumValues = new int[n][2];
        for (int i = 0; i < n; i++) {
            sumValues[i][0] = aliceValues[i] + bobValues[i];
            sumValues[i][1] = i;
        }
        Arrays.sort(sumValues, (a, b) -> b[0] - a[0]);
        int alice = 0;
        int bob = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                alice += aliceValues[sumValues[i][1]];
            } else {
                bob += bobValues[sumValues[i][1]];
            }
        }
        if (alice > bob) {
            return 1;
        } else if (alice < bob) {
            return -1;
        } else {
            return 0;
        }
    }
}