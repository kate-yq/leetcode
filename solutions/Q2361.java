public class Q2361 {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        long[] regulardp = new long[regular.length];
        long[] expressdp = new long[express.length];
        regulardp[0] = regular[0];
        expressdp[0] = expressCost + express[0];
        for (int i=1; i<regulardp.length; i++){
            regulardp[i] = Math.min(regulardp[i-1], expressdp[i-1])+regular[i];
            expressdp[i] = Math.min(regulardp[i-1]+expressCost, expressdp[i-1])+express[i];
        }
        long[] ans = new long[regular.length];
        for (int i=0; i<ans.length; i++){
            ans[i] = Math.min(regulardp[i], expressdp[i]);
        }
        return ans;
    }
}
