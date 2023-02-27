import java.util.HashMap;

class Q2062 {
    public int countVowelSubstrings(String word) {
        int j = 0, k = 0, vow = 0, cnt = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);

        for (int i = 0; i < word.length(); ++i) {
            if (map.get(word.charAt(i)) != null) {
                map.put(word.charAt(i), map.get(word.charAt(i)) + 1);
                if (map.get(word.charAt(i)) == 1) {
                    vow++;
                }
                while (vow == 5) {
                    map.put(word.charAt(k), map.get(word.charAt(k)) - 1);
                    if (map.get(word.charAt(k)) == 0) {
                        vow--;
                    }
                    k++;
                }
                cnt = cnt + (k - j);
            } else {
                map.forEach((k1, v) -> {
                    map.put(k1, 0);
                });
                vow = 0;
                j = i + 1;
                k = i + 1;
            }
        }
        return cnt;
    }
}