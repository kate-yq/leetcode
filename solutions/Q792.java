import java.util.*;

public class Q792 {
    public int numMatchingSubseq(String s, String[] words) {
        HashMap<Character, List<Integer>> indexs = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!indexs.containsKey(s.charAt(i))) {
                indexs.put(s.charAt(i), new ArrayList<>());
            }
            indexs.get(s.charAt(i)).add(i);
        }

        for (String w : words) {
            int cur = -1;
            int i = 0;
            for (; i < w.length(); i++) {
                if (!indexs.containsKey(w.charAt(i))) {
                    break;
                }
                cur = findLeastGreater(indexs.get(w.charAt(i)), cur);
                if (cur == -1) {
                    break;
                }
            }
            if (i == w.length()) {
                ans++;
            }
        }

        return ans;
    }

    private int findLeastGreater(List<Integer> arr, int target) {
        if (arr.get(0) > target) {
            return arr.get(0);
        }

        int lo = 0;
        int hi = arr.size();
        if (arr.get(hi - 1) <= target) {
            return -1;
        }

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr.get(mid) <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return arr.get(lo);
    }
}
