import java.util.HashMap;
import java.util.Map;
// import java.util.LinkedList;
// import java.util.Queue;

public class Q3 {
    public int lengthOfLongestSubstring(String s) {
        char[] letters = s.toCharArray();
        // the followings are optimal answer

        Map<Character, Integer> location =  new HashMap<Character,Integer>();
        int ans = 0;
        for (int left=0, right=0; right<letters.length; right++){
            if (location.containsKey(letters[right])){
                left=Math.max(location.get(letters[right]), left);
            }
            ans = Math.max(ans, right-left+1);
            location.put(letters[right], right+1);
        }
        return ans;

        // the followings are my original answer

        // Queue<Character> substring = new LinkedList<Character>();
        // int max = 0;
        // for (int i = 0; i < letters.length; i++) {
        //     while (substring.contains(letters[i])) {
        //         substring.poll();
        //     }
        //     substring.add(letters[i]);
        //     int temp = substring.size();
        //     if (temp > max) {
        //         max = temp;
        //     }
        // }
        // return max;
    }

    public static void main(String[] args) {
        String test_case_1 = "abcabcbb";
        String test_case_2 = "bbbbbb";
        String test_case_3 = "pwwwwkbew";
        Q3 loLS = new Q3();
        System.out.println("case 1 (exp 3): " + loLS.lengthOfLongestSubstring(test_case_1));
        System.out.println("case 2 (exp 1): " + loLS.lengthOfLongestSubstring(test_case_2));
        System.out.println("case 3 (exp 4): " + loLS.lengthOfLongestSubstring(test_case_3));
    }
}
