public class Q875 {
    public int minEatingSpeed(int[] piles, int h) {

        int lo = 1;
        int hi = (int) Math.pow(10, 9);

        while (lo < hi){
            int mid = lo + (hi-lo)/2;
            if (calculateHours(piles, mid) > h){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    private long calculateHours(int[] piles, int pace){
        long hour = 0;

        for (int pile : piles){
            hour += (pile / pace);
            if (pile % pace > 0){
                hour++;
            }
        }

        return hour;
    }
}
