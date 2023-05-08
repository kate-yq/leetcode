public class Q59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int num = 1;

        int upBond = 0;
        int lowBond = n-1;
        int leftBond = 0;
        int rightBond = n-1;

        while (num <= n*n){
            if (upBond <= lowBond){
                for (int i=leftBond; i<=rightBond; i++){
                    ans[upBond][i] = num;
                    num++;
                }
                upBond++;
            }

            if (leftBond <= rightBond){
                for (int i=upBond; i<=lowBond; i++){
                    ans[i][rightBond] = num;
                    num++;
                }
                rightBond--;
            }

            if (upBond <= lowBond){
                for (int i = rightBond; i>=leftBond; i--){
                    ans[lowBond][i] = num;
                    num++;
                }
                lowBond--;
            }

            if (leftBond <= rightBond){
                for (int i=lowBond; i>=upBond; i--){
                    ans[i][leftBond] = num;
                    num++;
                }
                leftBond++;
            }
        }
        return ans;
    }
}
