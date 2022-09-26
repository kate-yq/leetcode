import java.util.Arrays;

public class Q242 {
    public boolean isAnagram(String s, String t) {
        char[] s_letters = s.toCharArray();
        Arrays.sort(s_letters);
        char[] t_letters = t.toCharArray();
        Arrays.sort(t_letters);
        if (s_letters.length != t_letters.length) {
            return false;
        } else {
            for (int i = 0; i < s_letters.length; i++) {
                if (s_letters[i] != t_letters[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test_case_1_1 = "car";
        String test_case_1_2 = "rat";
        Q242 iA = new Q242();
        System.out.println(iA.isAnagram(test_case_1_1, test_case_1_2));
    }
}
