public class Q2672 {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] houses = new int[n];
        int[] ans = new int[queries.length];

        houses[queries[0][0]] = queries[0][1];
        
        for (int i=1; i<ans.length; i++){
            ans[i] = ans[i-1];

            int house = queries[i][0];
            int color = queries[i][1];
            int prevColor = houses[house];

            if (house > 0) {
                if (houses[house-1] == color){
                    ans[i]++;
                }
                if (prevColor != 0 && houses[house-1] == prevColor){
                    ans[i]--;
                }
            }

            if (house < n-1){
                if (houses[house+1] == color){
                    ans[i]++;
                }
                if (prevColor != 0 && houses[house+1] == prevColor){
                    ans[i]--;
                }
            }

            houses[house] = color;
        }

        return ans;
    }
}
