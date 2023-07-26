import java.util.ArrayList;
import java.util.List;

class Q2788 {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();

        for (String word : words) {
            int lastIn = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == separator) {
                    if (i > lastIn) {
                        ans.add(word.substring(lastIn, i));
                    }
                    lastIn = i + 1;
                }
            }
            if (lastIn < word.length()) {
                ans.add(word.substring(lastIn, word.length()));
            }
        }

        return ans;
    }
}