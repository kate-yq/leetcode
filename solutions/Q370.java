// import java.util.PriorityQueue;

public class Q370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        
        // if (updates.length==0){
        //     return ans;
        // }
        
        // PriorityQueue<int[]> indexToValue = new PriorityQueue<>(
        //     (a,b) -> a[0]-b[0]
        // );
        // for (int i=0; i<updates.length; i++){
        //     indexToValue.add(new int[]{updates[i][0], updates[i][2]});
        //     indexToValue.add(new int[]{updates[i][1]+1, -updates[i][2]});
        // }
        // int increment = 0;
        // int index = 0;
        // while (!indexToValue.isEmpty() && index<length){
        //     while (!indexToValue.isEmpty() && index == indexToValue.peek()[0]){
        //         increment += indexToValue.poll()[1];
        //     }
        //     ans[index] = increment;
        //     index++;
        // }
        // return ans;

        for (int i=0; i<updates.length; i++){
            ans[updates[i][0]] += updates[i][2];
            if (updates[i][1]<length-1){
                ans[updates[i][1]+1] -= updates[i][2];
            }
        }
        for (int i=1; i<length; i++){
            ans[i] += ans[i-1];
        }
        return ans;
    }
}
