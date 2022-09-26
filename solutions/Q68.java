import java.util.ArrayList;
import java.util.List;

public class Q68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> outcomes = new ArrayList<String>();
        int start = 0;
        while (start < words.length) {
            StringBuilder temp = new StringBuilder();
            int count = 0;
            int end = start;
            while (end < words.length) {
                if (count + words[end].length() <= maxWidth) {
                    count = count + words[end].length() + 1;
                    end++;
                } else {
                    break;
                }
            }
            count--;
            if (end == words.length) {
                while (start < end - 1) {
                    temp.append(words[start]);
                    temp.append(" ");
                    start++;
                }
                temp.append(words[start]);
                for (int i = 0; i < maxWidth - count; i++) {
                    temp.append(" ");
                }
            } else if (end - start == 1) {
                temp.append(words[start]);
                for (int i = 0; i < maxWidth - count; i++) {
                    temp.append(" ");
                }
            } else if (end - start == 2) {
                temp.append(words[start]);
                for (int i = 0; i <= maxWidth - count; i++) {
                    temp.append(" ");
                }
                start++;
                temp.append(words[start]);
            } else {
                int space2 = (maxWidth - count) / (end - start - 1);
                int space1 = maxWidth - count - space2 * (end - start - 1);
                for (int n=0; n<space1; n++){
                    temp.append(words[start]);
                    temp.append(" ");
                    for (int i = 0; i <= space2; i++) {
                        temp.append(" ");
                    }
                    start++;
                }
                while (start < end - 1) {
                    temp.append(words[start]);
                    for (int i = 0; i <= space2; i++) {
                        temp.append(" ");
                    }
                    start++;
                }
                temp.append(words[start]);
            }
            outcomes.add(temp.toString());
            start++;
        }
        return outcomes;
    }

    public static void main(String[] args) {
        String[] test_case_1 = { "This", "is", "an", "example", "of", "text", "justification." };
        String[] test_case_2 = { "What", "must", "be", "acknowledgment", "shall", "be" };
        String[] test_case_3 = { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to",
                "a", "computer.", "Art", "is", "everything", "else", "we", "do" };
        Q68 fJ = new Q68();
        System.out.println("test case 1:");
        for (String s : fJ.fullJustify(test_case_1, 16)) {
            System.out.println("[" + s + "]");
        }
        System.out.println("test case 2:");
        for (String s : fJ.fullJustify(test_case_2, 16)) {
            System.out.println("[" + s + "]");
        }
        System.out.println("test case 3:");
        for (String s : fJ.fullJustify(test_case_3, 20)) {
            System.out.println("[" + s + "]");
        }
    }
}