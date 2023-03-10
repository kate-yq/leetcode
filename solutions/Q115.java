import java.util.Arrays;

class Q115 {
    int[][] memo;

    public int numDistinct(String s, String t) {

        // the matching result from i in s, j in t
        this.memo = new int[s.length()][t.length()];

        for (int[] row : memo){
            Arrays.fill(row, -1);
        }
        
        return dp(s, 0, t, 0);
    }

    private int dp(String s, int i, String t, int j){
        if (j == t.length()){
            return 1;
        }
        // not enough chars in s to match
        if (s.length() - i < t.length() - j){
            return 0;
        }
        if (memo[i][j] != -1){
            return memo[i][j];
        }
        
        if (s.charAt(i) == t.charAt(j)){
            memo[i][j] = dp(s, i+1, t, j+1) + dp(s, i+1, t, j);
        } else {
            memo[i][j] = dp(s, i+1, t, j);
        }
        return memo[i][j];
    }
}