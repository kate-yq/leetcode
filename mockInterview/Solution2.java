import java.util.HashMap;

public class Solution2 {
    // "a" is palindrome
    // "" output 0
    // the letter could be rearranged
    // "A" and "a" is different

    // output = all even numbers + (all odd number-1) [+1]
    public int longestPalindrome(String s){
        if (s.length()==0){
            return 0;
        }
        int ans = 0;
        boolean odd =false;
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            if (!freq.containsKey(s.charAt(i))){
                freq.put(s.charAt(i), 0);
            }
            freq.put(s.charAt(i), freq.get(s.charAt(i))+1);
        }

        for (char c : freq.keySet()){
            if (freq.get(c)%2==1){
                ans = ans + freq.get(c)-1;
                odd = true;
            } else {
                ans = ans + freq.get(c);
            }
        }
        if (odd){
            ans++;
        }
        return ans;
    }

    public static void main(String[] args){
        String testcase1 = "abccccdd";
        String testcase2 = "aaabbbccccc";
        Solution2 lP = new Solution2();
        System.out.println("case1: "+lP.longestPalindrome(testcase1));
        System.out.println("case2: "+lP.longestPalindrome(testcase2));
    }
}
