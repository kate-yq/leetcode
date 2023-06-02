public class Q493 {
    int count = 0;
    int[] temp;

    public int reversePairs(int[] nums) {
        this.temp = new int[nums.length];

        sort(nums, 0, nums.length-1);

        return count;
    }

    private void sort(int[] nums, int lo, int hi){
        if (lo == hi){
            return;
        }

        int mid = lo + (hi-lo)/2;

        sort(nums, lo, mid);
        sort(nums, mid+1, hi);

        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi){
        for (int i=lo; i<=hi; i++){
            temp[i] = nums[i];
        }

        int end = mid+1;
        for (int i=lo; i<=mid; i++){
            while (end <= hi && (long)nums[i] > (long)nums[end]*2){
                end++;
            }
            count += (end - mid - 1);
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
