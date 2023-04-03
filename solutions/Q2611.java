import java.util.Arrays;

public class Q2611 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;

        int total = 0;

        for (int i=0; i<n; i++){
            total += reward2[i];
        }

        int[] diff = new int[n];
        
        for (int i=0; i<n; i++){
            diff[i] = reward1[i] - reward2[i];
        }
        Arrays.sort(diff);

        for (int i=0; i<k; i++){
            total += diff[i];
        }

        return total;
    }
}
