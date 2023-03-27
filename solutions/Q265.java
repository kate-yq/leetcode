public class Q265 {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[] cur = new int[k];
        int[] prev = costs[0];
        for (int i=1; i<n; i++){
            int min = prev[0];
            int minIndex = 0;
            int secondMin = Integer.MAX_VALUE;
            for (int j=1; j<k; j++){
                if (prev[j] < min){
                    secondMin = min;
                    min = prev[j];
                    minIndex = j;
                } else if (prev[j]<secondMin){
                    secondMin = prev[j];
                }
            }

            for (int j=0; j<k; j++){
                cur[j] = min + costs[i][j];
            }
            cur[minIndex] = secondMin+ costs[i][minIndex];
            prev = cur;
        }

        int minCost = prev[0];
        for (int j=1; j<k; j++){
            minCost = Math.min(minCost, prev[j]);
        }
        return minCost;
    }
}
