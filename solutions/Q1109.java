public class Q1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n+1];

        for (int[] booking : bookings){
            diff[booking[0]] += booking[2];
            if (booking[1] + 1 <= n){
                diff[booking[1] + 1] -= booking[2];
            }
        }

        int[] ans = new int[n];
        ans[0] = diff[1];

        for (int i=1; i<n; i++){
            ans[i] = ans[i-1] + diff[i+1];
        }
        
        return ans;
    }
}
