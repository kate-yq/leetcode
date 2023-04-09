
public class Q44 {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        if (p.length()>0 && p.charAt(0) == '*'){
            for (int i=0; i<=s.length(); i++){
                dp[i][1] = true;
            }
        }

        for (int i=0; i<=s.length(); i++){
            for (int j=1; j<=p.length(); j++){
                if (i>0 && (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')){
                    dp[i][j] |= dp[i-1][j-1];
                }
                if (p.charAt(j-1) == '*'){
                    for (int k = i; k>=0; k--){
                        dp[i][j] |= dp[k][j-1]; 
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
