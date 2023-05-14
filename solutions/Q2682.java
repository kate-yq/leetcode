import java.util.*;

public class Q2682 {
    public int[] circularGameLosers(int n, int k) {
        TreeSet<Integer> noBall = new TreeSet<>();
        HashSet<Integer> received  = new HashSet<>();

        for (int i=1; i<=n; i++){
            noBall.add(i);
        }

        int cur = 1;
        int count = 1;

        while (!received.contains(cur)){

            received.add(cur);
            noBall.remove(cur);

            cur = (cur + count * k) % n;

            if (cur == 0){
                cur = n;
            }

            count++;
        }

        int[] ans = new int[noBall.size()];
        int i = 0;

        for (int x : noBall){
            ans[i] = x;
            i++;
        }

        return ans;
    }
}
