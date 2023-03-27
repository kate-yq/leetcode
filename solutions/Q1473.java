public class Q1473 {
    int[][] cost;
    int[] houses;
    int target;
    int m, n;

    // Assign the size as per maximum value for different params
    Integer[][][] memo = new Integer[100][100][21];
    // Maximum cost possible plus 1
    final int MAX_COST = 1000001;
    
    int findMinCost(int currIndex, int neighborhoodCount, int prevHouseColor) {
        if (currIndex == m) {
            // If all houses are traversed, check if the neighbor count is as expected or not
            return neighborhoodCount == target ? 0 : MAX_COST;
        }
        
        if (neighborhoodCount > target) {
            // If the neighborhoods are more than the threshold, we can't have target neighborhoods
            return MAX_COST;
        }
        
        // We have already calculated the answer so no need to go into recursion
        if (memo[currIndex][neighborhoodCount][prevHouseColor] != null) {
            return memo[currIndex][neighborhoodCount][prevHouseColor];
        }
        
        int minCost = MAX_COST;
        // If the house is already painted, update the values accordingly
        if (houses[currIndex] != 0) {
            int newNeighborhoodCount = neighborhoodCount + (houses[currIndex] != prevHouseColor ? 1 : 0);
            minCost = 
                findMinCost(currIndex + 1, newNeighborhoodCount, houses[currIndex]);
        } else {
            // If the house is not painted, try every possible color and store the minimum cost
            for (int color = 1; color <= n; color++) {
                int newNeighborhoodCount = neighborhoodCount + (color != prevHouseColor ? 1 : 0);
                int currCost = cost[currIndex][color - 1] 
                    + findMinCost(currIndex + 1, newNeighborhoodCount, color);
                minCost = Math.min(minCost, currCost);
            }
        }
        
        // Return the minimum cost and also storing it for future reference (memoization)
        return memo[currIndex][neighborhoodCount][prevHouseColor] = minCost;
    }
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.cost = cost;
        this.houses = houses;
        this.target = target;
        this.m = m;
        this.n = n;
        int answer = findMinCost(0, 0, 0);
        // Return -1 if the answer is MAX_COST as it implies no answer possible
        return answer == MAX_COST ? -1 : answer;
    }
}
