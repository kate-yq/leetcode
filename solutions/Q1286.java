import java.util.ArrayList;
import java.util.List;

public class Q1286 {
    List<String> allcombs;
    int cur = 0;

    public Q1286(String characters, int combinationLength) {
        allcombs = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        backtrack(characters, combinationLength, 0, temp);
    }

    private void backtrack(String s, int len, int start, StringBuilder temp){
        if (temp.length() == len){
            allcombs.add(temp.toString());
            return;
        }
        if (start >= s.length()){
            return;
        }
        for (int i=start; i<s.length(); i++){
            temp.append(s.charAt(i));
            backtrack(s, len, i+1, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    
    public String next() {
        String ans = allcombs.get(cur);
        cur++;
        return ans;
    }
    
    public boolean hasNext() {
        return cur<allcombs.size();
    }
}
