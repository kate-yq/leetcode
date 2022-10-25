import java.util.HashSet;
import java.util.List;

class Q139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        HashSet<String> dict = new HashSet<>();
        for (String word : wordDict){
            dict.add(word);
        }
        for (int i = 0; i<s.length(); i++){
            dp[i] = dict.contains(s.substring(0, i+1));
            int j=0;
            while (!dp[i] && j<i){
                dp[i] = dp[j] && (dict.contains(s.substring(j+1, i+1)));
                j++;
            }
            
        }
        return dp[s.length()-1];
    }
}