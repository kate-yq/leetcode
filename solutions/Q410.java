public class Q410 {
    public int splitArray(int[] nums, int k) {
        int lo = 0;
        int hi = 0;
        
        for (int num : nums){
            lo = Math.max(lo, num);
            hi += num;
        }

        while (lo < hi){
            int mid = lo + (hi-lo)/2;

            if (calculateSub(nums, mid) > k){
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return hi;
    }

    private int calculateSub(int[] nums, int maxCap){
        int count = 0;
        int temp = 0;

        for (int num : nums){
            if (temp + num > maxCap){
                count++;
                temp = num;
            } else {
                temp += num;
            }
        }
        count++;

        return count;
    }
}
