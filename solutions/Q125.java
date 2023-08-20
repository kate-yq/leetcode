public class Q125 {
    public boolean isPalindrome(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            } else if (Character.isDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString().equals(sb.reverse().toString());

        // if (s.length() == 0 || s.length() == 1) {
        // return true;
        // }
        // int[] ascii = new int[s.length()];
        // for (int i = 0; i < s.length(); i++) {
        // if ((int) s.charAt(i) > 96 && (int) s.charAt(i) < 123) {
        // ascii[i] = (int) s.charAt(i);
        // } else if ((int) s.charAt(i) > 64 && (int) s.charAt(i) < 91) {
        // ascii[i] = (int) s.charAt(i) + 32;
        // } else if ((int) s.charAt(i) > 47 && (int) s.charAt(i) < 58) {
        // ascii[i] = (int) s.charAt(i);
        // }
        // }
        // int left = 0;
        // int right = ascii.length - 1;
        // while (left < right) {
        // if (ascii[left] == 0) {
        // left++;
        // continue;
        // }
        // if (ascii[right] == 0) {
        // right--;
        // continue;
        // }
        // if (ascii[left] != ascii[right]) {
        // return false;
        // } else {
        // left++;
        // right--;
        // }
        // }
        // return true;
    }
}
