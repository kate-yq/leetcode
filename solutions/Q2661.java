import java.util.HashMap;

public class Q2661 {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        HashMap<Integer, int[]> locations = new HashMap<>();
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                locations.put(mat[i][j], new int[]{i,j});
            }
        }

        HashMap<Integer, Integer> rows = new HashMap<>();
        HashMap<Integer, Integer> cols = new HashMap<>();
        for (int i=0; i<arr.length; i++){
            int[] index = locations.get(arr[i]);
            rows.put(index[0], rows.getOrDefault(index[0], 0)+1);
            cols.put(index[1], cols.getOrDefault(index[1], 0)+1);
            if (rows.get(index[0])==n || cols.get(index[1])==m){
                return i;
            }
        }
        return -1;
    }
}
