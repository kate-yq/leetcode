import java.util.ArrayList;

public class Q338 {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ArrayList<Integer> section = new ArrayList<>();
        section.add(1);
        int index = 1;
        while (index <= n){
            int size = section.size();
            for (int i=0; i<size && index <= n; i++){
                ans[index] = section.get(i);
                section.add(ans[index]+1);
                index++;
            }
        }
        return ans;
    }
}
