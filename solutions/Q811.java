import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> results = new ArrayList<>();
        Map<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] visits = cpdomains[i].split(" ");
            String[] domains = visits[1].split("\\.");
            StringBuilder domain = new StringBuilder();
            for (int j = domains.length - 1; j >= 0; j--) {
                if (j == domains.length - 1) {
                    domain.insert(0, domains[j]);
                } else {
                    domain.insert(0, ".");
                    domain.insert(0, domains[j]);
                }
                if (mp.containsKey(domain.toString())) {
                    mp.put(domain.toString(), mp.get(domain.toString()) + Integer.valueOf(visits[0]));
                } else {
                    mp.put(domain.toString(), Integer.valueOf(visits[0]));
                }
            }
        }
        for (String domain : mp.keySet()) {
            StringBuilder visit = new StringBuilder();
            visit.append(mp.get(domain).toString());
            visit.append(" ");
            visit.append(domain);
            results.add(visit.toString());
        }
        return results;
    }

    public static void main(String[] args) {
        String[] test_case_1 = { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
        Q811 sV = new Q811();
        for (String s : sV.subdomainVisits(test_case_1)) {
            System.out.print("\'" + s + "\',");
        }
    }
}
