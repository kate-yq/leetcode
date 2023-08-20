import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q30 {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        List<Integer> ans = new ArrayList<>();
        int k = words[0].length();
        int n = words.length;

        for (int i = 0; i < k; i++) {
            Map<String, Integer> window = new HashMap<>();
            int l = i;
            int r = l;
            while (r + k <= s.length()) {
                String cur = s.substring(r, r + k);
                r += k;

                if (freq.containsKey(cur)) {
                    window.put(cur, window.getOrDefault(cur, 0) + 1);
                } else {
                    l = r;
                    window.clear();
                    continue;
                }
                while (window.get(cur) > freq.get(cur)) {
                    String left = s.substring(l, l + k);
                    window.put(left, window.get(left) - 1);
                    l += k;
                }
                if (r - l == k * n) {
                    ans.add(l);
                }
            }
        }

        return ans;
    }
}
