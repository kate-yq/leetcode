import java.util.Arrays;

public class Q2800 {
    public String minimumString(String a, String b, String c) {
        // abc,cba
        // cab,bac
        // acb,bca

        String[] res = new String[6];
        res[0] = combine(combine(a, b), c);
        res[1] = combine(combine(c, b), a);
        res[2] = combine(combine(c, a), b);
        res[3] = combine(combine(b, a), c);
        res[4] = combine(combine(a, c), b);
        res[5] = combine(combine(b, c), a);

        Arrays.sort(res, (p, q) -> {
            if (p.length() == q.length()) {
                return p.compareTo(q);
            }
            return p.length() - q.length();
        });

        return res[0];
    }

    private String combine(String p, String q) {
        if (p.contains(q)) {
            return p;
        }
        if (q.contains(p)) {
            return q;
        }

        int p_q = 0;

        for (int i = 1; i <= p.length() && i <= q.length(); i++) {
            if (q.startsWith(p.substring(p.length() - i, p.length()))) {
                p_q = i;
            }
        }

        return p + q.substring(p_q, q.length());
    }
}
