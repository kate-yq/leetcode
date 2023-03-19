public class Q34 {
    public int[] searchRange(int[] nums, int target) {

        // find the index of element that is just smaller than target
        // and the index of element that is just larger than target
        // return [left+1, right-1]
        // if left+1 > right-1, means no such element, therefore return [-1,-1]
        int n = nums.length;

        if (n == 0 || nums[0] > target || nums[n-1]<target){
            return new int[]{-1,-1};
        }

        int leftBond = 0; 
        int rightBond = 0;

        // search for left bond
        int l = -1, r = n;
        while(l < r-1){
            int mid = l + (r-l)/2;
            if (nums[mid] < target){
                l = mid;
            } else {
                r = mid-1;
            }
        }
        if (r == -1 || nums[r]<target){
            leftBond = r;
        } else {
            leftBond = l;
        }

        // search for right bond
        l = -1;
        r = n;
        while(l < r-1){
            int mid = l + (r-l)/2;
            if (nums[mid] <= target){
                l = mid+1;
            } else {
                r = mid;
            }
        }
        if (l == n || nums[l]>target){
            rightBond = l;
        } else {
            rightBond = r;
        }

        return (leftBond+1>rightBond-1)? new int[]{-1,-1}: new int[]{leftBond+1, rightBond-1};
    }
}
