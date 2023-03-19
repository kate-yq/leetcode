public class Q10 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int col=1; col<dp[0].length; col++){
            if (p.charAt(col-1) == '*'){
                dp[0][col] = dp[0][col-2];
            } 
        }
        for (int row = 1; row<dp.length; row++){
            for (int col = 1; col<dp[0].length; col++){
                if (p.charAt(col-1) == '.' || p.charAt(col-1)==s.charAt(row-1)){
                    dp[row][col] = dp[row-1][col-1];
                } else if (p.charAt(col-1) == '*'){
                    // if * means 0 of previous
                    dp[row][col] = dp[row][col-2];
                    // if * means 1 or more of previous
                    if (p.charAt(col-2) == '.' || p.charAt(col-2)==s.charAt(row-1)){
                        dp[row][col] |= dp[row-1][col];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
