import java.util.HashMap;
import java.util.Map;

class Q424 {
    public int characterReplacement(String s, int k) {
        char[] letters = s.toCharArray();
        int max_freq = 0;
        int len = 0;
        Map<Character, Integer> letter_freq = new HashMap<>();
        for (int right = 0, left = 0; right < letters.length; right++) {
            // add right pointer to the window
            // update letter frequency and max frequency
            if(letter_freq.containsKey(letters[right])){
                letter_freq.put(letters[right], letter_freq.get(letters[right])+1);
            } else {
                letter_freq.put(letters[right],1);
            }
            max_freq = Math.max(max_freq, letter_freq.get(letters[right]));
            // check if the letters needing change exceed k
            // if yes, right shift left pointer
            // what if delete a letter with max frequency? do nothing to max_freq??
            // ???????????????
            if (right - left +1-max_freq>k){
                letter_freq.put(letters[left], letter_freq.get(letters[left])-1);
                left++;
            }
            len = Math.max(len, right-left+1);
        }
        return len;
    }

    public static void main(String[] args) {
        String test_case_1= "aabbcde";
        String test_case_2= "baaabdda";
        Q424 cR = new Q424();
        System.out.println("test case 1(exp3): "+cR.characterReplacement(test_case_1, 1));
        System.out.println("test case 2(exp5): "+cR.characterReplacement(test_case_2, 2));
    }
}