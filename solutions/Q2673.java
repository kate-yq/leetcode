public class Q2673 {
    int[] remainingCosts;
    int[] cost;
    int n;
    int max;

    public int minIncrements(int n, int[] cost) {
        this.remainingCosts = new int[n];
        this.cost = cost;
        this.n = n;
        this.max = 0;

        findAllCosts(0, 0);

        for (int i=n/2; i<n; i++){
            remainingCosts[i] = max - remainingCosts[i];
        }

        for (int i=n/2-1; i>=0; i--){
            int common = Math.min(remainingCosts[(i+1)*2-1], remainingCosts[(i+1)*2]);
            remainingCosts[i] = common;
            remainingCosts[(i+1)*2-1] -= common;
            remainingCosts[(i+1)*2] -= common;
        }

        int sum = 0;

        for (int c : remainingCosts){
            sum += c;
        }

        return sum;
    }

    private void findAllCosts(int cur, int sum){
        if (cur >= n){
            return;
        }

        sum += cost[cur];
        remainingCosts[cur] = sum;
        max = Math.max(max, sum);
        
        // find left
        findAllCosts((cur+1)*2-1, sum);
        // finf right
        findAllCosts((cur+1)*2, sum);
    }
}
