public class Q70 {
    int[] memo;

    public int climbStairs(int n) {
        this.memo = new int[n+1];
        return _climb(0, n);
    }

    private int _climb(int coverred, int total){
        if (coverred > total){
            return 0;
        }
        if (coverred == total){
            return 1;
        }
        if (memo[coverred]>0){
            return this.memo[coverred];
        }
        this.memo[coverred] = _climb(coverred+1, total) + _climb(coverred+2, total);
        return this.memo[coverred];
    }
}
