public class Q704 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int medium = (left + right)/2;
            if (nums[medium] < target){
                left = medium+1;
            } else if (nums[medium] > target){
                right = medium-1;
            } else {
                return medium;
            }
        }
        return -1;
    }
}
