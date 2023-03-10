public class Q72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m+1][n+1];

        for (int i=0; i<=m; i++){
            memo[i][0] = i;
        }
        for (int j=0; j<=n; j++){
            memo[0][j] = j;
        }

        for (int i=1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    // skip current char
                    memo[i][j] = memo[i-1][j-1];
                } else {
                    memo[i][j] = min(
                        memo[i][j-1]+1, 
                        memo[i-1][j]+1,
                        memo[i-1][j-1]+1
                    );
                }
            }
        }
        return memo[m][n];
    }

    private int min(int insert, int delete, int swap){
        return Math.min(insert, Math.min(delete, swap));
    }
}
