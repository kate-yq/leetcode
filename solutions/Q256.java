public class Q256 {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int prev_red = costs[0][0];
        int prev_blue = costs[0][1];
        int prev_white = costs[0][2];
        int red,blue,white;
        for (int i=1; i<n; i++){
            red = costs[i][0] + Math.min(prev_blue, prev_white);
            blue = costs[i][1] + Math.min(prev_red, prev_white);
            white = costs[i][2] + Math.min(prev_red, prev_blue);
            prev_red = red;
            prev_blue = blue;
            prev_white = white;
        }
        return Math.min(prev_red, Math.min(prev_blue, prev_white));
    }
}
