public class Q190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i=0; i<32; i++){
            int digit = n & 1;
            ans += digit << (31-i);
            n = n >> 1;
        }
        return ans;
    }
}
