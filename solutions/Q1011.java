class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        int hi = 0;

        for (int w: weights){
            lo = Math.max(lo, w);
            hi += w;
        }

        while (lo < hi){
            int mid = lo + (hi - lo)/2;
            if (calculateDays(weights, mid) > days){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return hi;
    }

    private int calculateDays(int[] weights, int capacity){
        int day = 0;
        int temp = 0;

        for (int i=0; i<weights.length; i++){
            if (temp + weights[i] <= capacity){
                temp += weights[i];
            } else {
                day++;
                temp = weights[i];
            }
        }
        day++;

        return day;
    }
}