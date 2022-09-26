public class Q125 {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }
        int[] ascii = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) > 96 && (int) s.charAt(i) < 123) {
                ascii[i] = (int) s.charAt(i);
            } else if ((int) s.charAt(i) > 64 && (int) s.charAt(i) < 91) {
                ascii[i] = (int) s.charAt(i) + 32;
            } else if ((int) s.charAt(i) > 47 && (int) s.charAt(i) < 58) {
                ascii[i] = (int) s.charAt(i);
            }
        }
        int left = 0;
        int right = ascii.length - 1;
        while (left < right) {
            if (ascii[left] == 0) {
                left++;
                continue;
            }
            if (ascii[right] == 0) {
                right--;
                continue;
            }
            if (ascii[left] != ascii[right]) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String test_case_1 = "0P";
        Q125 iP = new Q125();
        System.out.println(iP.isPalindrome(test_case_1));
    }
}
