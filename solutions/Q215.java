import java.util.Random;

class Q215 {
    int[] nums;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        return quickselect(k-1, 0, nums.length-1);
    }

    private int quickselect(int kth, int left, int right){
        if (left == right){
            return nums[left];
        }
        Random random_num = new Random();
        int rand = left + random_num.nextInt(right - left); 
        swap(left, rand);

        int index = left;
        int r = right;
        // move larger ones to left, move smaller ones to right
        while (index < r){
            if (nums[index] < nums[index+1]){
                swap(index, index+1);
                index++;
            } else if (nums[index] == nums[index+1]){
                index++;
            } else {
                swap(index+1, r);
                r--;
            }
        }
        if (index == kth) {
            return nums[index];
        } else if (index > kth){
            return quickselect(kth, left, index-1);
        } else {
            return quickselect(kth, index+1, right);
        }
    }

    private void swap(int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}