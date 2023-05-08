public class Q1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];

        for (int[] trip : trips){
            diff[trip[1]] += trip[0];
            diff[trip[2]] -= trip[0];
        }

        if (diff[0] > capacity){
            return false;
        }

        int[] stations = new int[1001];
        stations[0] = diff[0];

        for (int i=1; i<1001; i++){
            stations[i] = stations[i-1] + diff[i];
            if (stations[i] > capacity){
                return false;
            }
        }
        return true;
    }
}
