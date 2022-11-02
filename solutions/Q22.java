import java.util.ArrayList;
// import java.util.HashSet;
import java.util.List;

public class Q22 {

    // recursive way

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recurse(res, 0, 0, "", n);
        return res;
    }
    
    public void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        
        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }
        
        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }

    // the following is my original answer

    // HashSet<String> results;

    // public List<String> generateParenthesis(int n) {
    //     this.results = new HashSet<>();
    //     List<String> ans =  new ArrayList<>();
    //     StringBuilder combination = new StringBuilder();
    //     combination.append("()");
    //     dfs(combination, n, 2);

    //     for (String s : results){
    //         ans.add(s);
    //     }
    //     return ans;
    // }

    // private void dfs(StringBuilder comnination, int n, int cur_len){
    //     if (cur_len == n*2){
    //         this.results.add(comnination.toString());
    //         return;
    //     }
    //     for (int i=0; i<=cur_len; i++){
    //         dfs(comnination.insert(i, "()"), n, cur_len+2);
    //         comnination.delete(i, i+2);
    //     }
    //     return;
    // }
}
