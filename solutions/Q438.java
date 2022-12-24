import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Q438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> results = new ArrayList<>();
        if (p.length()>s.length()){
            return results;
        }

        HashMap<Character, Integer> p_count = new HashMap<>();
        HashMap<Character, Integer> s_count = new HashMap<>();
        for (int i=0; i<p.length(); i++){
            if (p_count.containsKey(p.charAt(i))){
                p_count.put(p.charAt(i), p_count.get(p.charAt(i))+1);
            } else {
                p_count.put(p.charAt(i), 1);
            }
        }
        int left = 0;
        int right = 0;
        while (right<s.length()){
            if (!p_count.containsKey(s.charAt(right))){
                s_count = new HashMap<>();
                left = right+1;
                right=left;
                continue;
            }
            if (right<left+p.length()){
                if (s_count.containsKey(s.charAt(right))){
                    s_count.put(s.charAt(right), s_count.get(s.charAt(right))+1);
                } else {
                    s_count.put(s.charAt(right), 1);
                }
            } else {
                if (s_count.containsKey(s.charAt(right))){
                    s_count.put(s.charAt(right), s_count.get(s.charAt(right))+1);
                } else {
                    s_count.put(s.charAt(right), 1);
                }
                s_count.put(s.charAt(left), s_count.get(s.charAt(left))-1);
                if (s_count.get(s.charAt(left))==0){
                    s_count.remove(s.charAt(left));
                }
                left++;
            }
            if (s_count.equals(p_count)){
                results.add(left);
            }
            right++;
        }
        return results;
    }
}
