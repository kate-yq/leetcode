import java.util.ArrayList;
import java.util.List;

public class Q68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int l = 0;
        int r = 0;

        List<String> ans = new ArrayList<>();

        while (r < words.length) {
            int sum = 0;
            while (r < words.length && sum + words[r].length() + r - l <= maxWidth) {
                sum += words[r].length();
                r++;
            }
            if (r < words.length) {
                ans.add(getLine(words, l, r, sum, maxWidth));
            } else {
                ans.add(getLastLine(words, l, r, sum, maxWidth));
            }

            l = r;
        }

        return ans;
    }

    private String getLine(String[] words, int l, int r, int sum, int maxWidth) {
        StringBuilder sb = new StringBuilder();

        if (r - l == 1) {
            return getLastLine(words, l, r, sum, maxWidth);
        }

        int space = (maxWidth - sum) / (r - 1 - l);
        int remain = (maxWidth - sum) % (r - 1 - l);

        for (int i = 0; i < remain; i++) {
            sb.append(words[l]);
            for (int j = 0; j < space + 1; j++) {
                sb.append(" ");
            }
            l++;
        }

        while (l < r - 1) {
            sb.append(words[l]);
            for (int j = 0; j < space; j++) {
                sb.append(" ");
            }
            l++;
        }

        sb.append(words[l]);

        return sb.toString();
    }

    private String getLastLine(String[] words, int l, int r, int sum, int maxWidth) {
        StringBuilder sb = new StringBuilder();

        int remain = maxWidth - sum - (r - 1 - l);

        while (l < r - 1) {
            sb.append(words[l]);
            sb.append(" ");
            l++;
        }

        sb.append(words[l]);
        for (int i = 0; i < remain; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }
}