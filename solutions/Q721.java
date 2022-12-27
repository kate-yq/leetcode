import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Q721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> results = new ArrayList<>();
        HashMap<String, HashSet<HashSet<String>>> map = new HashMap<>();
        for (List<String> account : accounts){
            String name = account.get(0);
            if (map.containsKey(name)){
                boolean existing = false;
                for (HashSet<String> emails : map.get(name)){
                    for (int i=1; i<account.size(); i++){
                        if (emails.contains(account.get(i))){
                            for (int j=1; j<account.size(); j++){
                                emails.add(account.get(j));
                            }
                            existing = true;
                            break;
                        }
                    }
                    if (existing){
                        break;
                    }
                }
                if (!existing){
                    HashSet<String> new_emails = new HashSet<>();
                    for (int k=1; k<account.size(); k++){
                        new_emails.add(account.get(k));
                    }
                    map.get(name).add(new_emails);
                }
            } else {
                HashSet<String> new_emails = new HashSet<>();
                for (int k=1; k<account.size(); k++){
                    new_emails.add(account.get(k));
                }
                map.put(name, new HashSet<HashSet<String>>());
                map.get(name).add(new_emails);
            }
        }

        for (String people : map.keySet()){
            for (HashSet<String> emails : map.get(people)){
                List<String> account =  new ArrayList<>();
                for (String email : emails){
                    account.add(email);
                }
                account.sort((s1, s2) -> {
                    for (int i=0; i<s1.length() && i<s2.length(); i++){
                        if (s1.charAt(i) != s2.charAt(i)){
                            return s1.charAt(i)-s2.charAt(i);
                        }
                    }
                    return s1.length()-s2.length();
                });
                account.add(0, people);
                results.add(account);
            }
        }
        return results;
    }
}
