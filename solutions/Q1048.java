import java.util.Arrays;

class Q1048 {
    public int longestStrChain(String[] words) {
        // sorting by length in ascending order
        Arrays.sort(words, (a,b)->a.length()-b.length());
        
        // dp to store the length of longest chain up to current element
        // min is 1
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);

        int max_len = 1;
        for (int i=0; i<dp.length; i++){
            for (int j=i-1; j>=0 && words[i].length()-words[j].length()<2; j--){
                if (predecessor(words[i],words[j])){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max_len = Math.max(max_len, dp[i]);
        }
        return max_len;
    }

    // determine if a is the predecessor of b
    private boolean predecessor(String a, String b){
        if (a.length()-b.length()!=1){
            return false;
        }
        int i=0;    // index in a
        int j=0;    // index in b
        while(i-j<=1){
            if (j == b.length()){
                return true;
            }
            if (a.charAt(i) == b.charAt(j)){
                i++;
                j++;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        String[] test_case_1 = {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        String[] test_case_2 = {"bdca", "bda", "ca", "dca", "a"};
        Q1048 lSC = new Q1048();
        System.out.println(lSC.longestStrChain(test_case_1));
        System.out.println(lSC.longestStrChain(test_case_2));
    }
}