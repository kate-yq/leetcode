public class Q1340 {
    int[] dp;
    int[] arr;

    public int maxJumps(int[] arr, int d) {
        this.arr = arr;
        this.dp = new int[arr.length];
        int max=0;
        for (int i=0; i<arr.length; i++){
            max = Math.max(max,jump(i,d));
        }
        return max;
    }

    private int jump(int start, int d){
        if (dp[start]!=0){
            return dp[start];
        }
        dp[start] = 1;
        // jump left:
        if (start > 0 && arr[start-1]<arr[start]){
            for (int i=start-1; i>=start-d && i>=0 && arr[i]<arr[start]; i--){
                dp[start] = Math.max(dp[start], jump(i,d)+1);
            }
        }

        // jump right:
        if (start < arr.length-1 && arr[start+1]<arr[start]){
            for (int i=start+1; i<=start+d && i<arr.length && arr[i]<arr[start]; i++){
                dp[start] = Math.max(dp[start], jump(i,d)+1);
            }
        }
        return dp[start];
    }

    public static void main(String[] args){
        int[] testcase = {83,11,83,70,75,45,96,11,80,75,67,83,6,51,71,64,64,42,70,23,11,24,95,65,1,54,31,50,18,16,11,86,2,48,37,34,65,67,4,17,33,70,16,73,57,96,30,26,56,1,16,74,82,77,82,62,32,90,94,33,58,23,23,65,70,12,85,27,38,100,93,49,96,96,77,37,69,71,62,34,4,14,25,37,70,3,67,88,20,30};
        Q1340 mJ = new Q1340();
        System.out.print(mJ.maxJumps(testcase, 29));
    }
}
