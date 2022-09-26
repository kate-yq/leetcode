import java.util.HashMap;
import java.util.Map;

public class Q76 {
    public String minWindow(String s, String t) {
        // the map records each letter_freq in s minus in t
        // if all >= 0, then fulfill the requirements
        Map<Character, Integer> s_minus_t = new HashMap<>();

        // record the letters and frequence in t
        for (int i = 0; i < t.length(); i++) {
            if (s_minus_t.containsKey(t.charAt(i))) {
                s_minus_t.put(t.charAt(i), s_minus_t.get(t.charAt(i)) - 1);
            } else {
                s_minus_t.put(t.charAt(i), -1);
            }
        }

        // silding window to find qualified substring
        int start = 0;
        int end = -1;
        for (int right = 0, left = 0; right < s.length(); right++) {
            if (s_minus_t.containsKey(s.charAt(right))) {
                s_minus_t.put(s.charAt(right), s_minus_t.get(s.charAt(right)) + 1);
            }
            // shift left if right meet all letters
            boolean qualified = true;
            for (char letter : s_minus_t.keySet()) {
                if (s_minus_t.get(letter) < 0) {
                    qualified = false;
                    break;
                }
            }
            while (qualified) {
                if (!s_minus_t.containsKey(s.charAt(left))){
                    left++;
                } else if (s_minus_t.get(s.charAt(left)) > 0) {
                    s_minus_t.put(s.charAt(left), s_minus_t.get(s.charAt(left)) - 1);
                    left++;
                } else {
                    break;
                }
            }
            // update string marker if shorter
            if (qualified) {
                if (end - start + 1 == 0 || end - start + 1 > right - left + 1) {
                    start = left;
                    end = right;
                }
            }
        }
        if (end - start + 1 == 0) {
            return "";
        } else {
            StringBuilder result = new StringBuilder();
            for (int i = start; i <= end; i++) {
                result.append(s.charAt(i));
            }
            return result.toString();
        }
    }

    public static void main(String[] args) {
        String test_case_1 = "ADOBECODEBANC";
        String test_case_2 = "a";
        Q76 mW = new Q76();
        System.out.println("case 1(exp BANC): " + mW.minWindow(test_case_1, "ABC"));
        System.out.println("case 2(exp a): " + mW.minWindow(test_case_2, "a"));
        System.out.println("case 1(exp null): " + mW.minWindow(test_case_2, "aa"));
    }
}
