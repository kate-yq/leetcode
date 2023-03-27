public class Q2595 {
    public int[] evenOddBit(int n) {
        int[] ans = new int[2];
        boolean lastOdd = false;
        while(n > 0){
            if ((n&1)>0){
                if (lastOdd){
                    ans[1]++;
                } else {
                    ans[0]++;
                }
            }
            n = n >>1;
            lastOdd = ! lastOdd;
        }
        return ans;
    }
}
