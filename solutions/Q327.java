public class Q327 {
    long[] temp;
    int count;
    int lower;
    int upper;

    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] prefix = new long[n+1];

        for (int i=0; i<n; i++){
            prefix[i+1] = (long)nums[i] + prefix[i];
        }

        this.temp = new long[n+1];
        this.count = 0;
        this.lower = lower;
        this.upper = upper;

        sort(prefix, 0, n);

        return count;
    }

    private void sort(long[] nums, int lo, int hi){
        if(lo == hi){
            return;
        }

        int mid = lo + (hi-lo)/2;

        sort(nums, lo, mid);
        sort(nums, mid+1, hi);

        merge(nums, lo, mid, hi);
    }

    private void merge(long[] nums, int lo, int mid, int hi){
        for (int i=lo; i<=hi; i++){
            temp[i] = nums[i];
        }

        int start = mid+1;
        int end = mid+1;

        for (int i=lo; i<=mid; i++){
            while (start<=hi && nums[start]-nums[i]<lower){
                start++;
            }
            while (end<=hi && nums[end]-nums[i]<=upper){
                end++;
            }

            count += (end - start);
        }

        int i = lo;
        int j = mid+1;

        for (int p=lo; p<=hi; p++){
            if (i>mid){
                nums[p] = temp[j++];
            } else if (j>hi){
                nums[p] = temp[i++];
            } else if (temp[i]>temp[j]){
                nums[p] = temp[j++];
            } else {
                nums[p] = temp[i++];
            }
        }
    }
}
