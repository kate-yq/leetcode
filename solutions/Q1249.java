public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int bal = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                bal++;
                sb.append("(");
            } else if (s.charAt(i) == ')') {
                bal--;
                if (bal < 0) {
                    bal = 0;
                } else {
                    sb.append(")");
                }
            } else {
                sb.append(s.charAt(i));
            }
        }

        int in = sb.length() - 1;
        while (bal > 0 && in >= 0) {
            if (sb.charAt(in) == '(') {
                sb.deleteCharAt(in);
                bal--;
            }
            in--;
        }
        return sb.toString();
    }
}