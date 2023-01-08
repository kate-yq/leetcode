import java.util.Random;

public class Q528 {
    int[] presum;

    public Q528(int[] w) {
        this.presum = new int[w.length];
        int sum = 0;
        for (int i=0; i<w.length; i++){
            sum += w[i];
            presum[i] = sum;
        }
    }
    
    public int pickIndex() {
        Random rand = new Random();
        int num = rand.nextInt(this.presum[presum.length-1]);
        for (int i=0; i<presum.length; i++){
            if (presum[i] > num){
                return i;
            }
        }
        return presum.length-1;
    }
}
