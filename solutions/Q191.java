public class Q191 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        int searching = 1;
        for (int i=0; i<32; i++){
            if ((n & searching) != 0){
                ans++;
            }
            searching <<= 1;
        }
        return ans;
    }
}