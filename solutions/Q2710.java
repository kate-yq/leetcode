public class Q2710 {
    public String removeTrailingZeros(String num) {
        StringBuilder sb = new StringBuilder(num);
        while (sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}
