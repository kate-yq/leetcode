public class Q97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length()+s2.length()){
            return false;
        }

        // the first i in s1 and j in s2 could form first i+j in s3?
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;

        for (int i = 0; i<=s1.length(); i++){
            for (int j=0; j<=s2.length(); j++){
                if (i>0 && s3.charAt(i+j-1) == s1.charAt(i-1)){
                    dp[i][j] |= dp[i-1][j];
                }
                if (j>0 && s3.charAt(i+j-1) == s2.charAt(j-1)){
                    dp[i][j] |= dp[i][j-1];
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
