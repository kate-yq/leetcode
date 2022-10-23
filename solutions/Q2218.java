import java.util.List;

public class Q2218 {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        // creat array contains sum of first k elements
        int[][] dp = new int[piles.size()+1][k+1];
        int i = 1;
        for (List<Integer> pile : piles){
            int sum = 0;
            int j = 1;
            for(int num : pile){
                sum += num;
                dp[i][j] = sum;
                j++;
                if (j == k+1){
                    break;
                }
            }
            i++;
        }

        // change it to the following int[][]
        // int[m][n] dp to store the largest sum of first m piles and n elements
        // int[0][n] = 0; int[m][0] = 0;
        for (int pile = 2; pile < dp.length; pile++){
            for (int elements=k; elements>0; elements--){
                for (int remove = 0; remove <= k; remove++){
                    if(remove<=elements){
                        dp[pile][elements] = Math.max(dp[pile-1][elements-remove]+dp[pile][remove], dp[pile][elements]);
                    }
                }
            }
        }
        return dp[dp.length-1][k];
    }
}
