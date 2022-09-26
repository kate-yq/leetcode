public class Q153 {
    public int findMin(int[] nums) {
        // because the unroasted array is strictly sorted
        // the left point of roasted array is larger than the right point
        // hence, binary search can be used

        if (nums.length ==1){
            return nums[0];
        }

        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int medium = left + (right - left)/2;
            if (nums[medium] < nums[right]){
                right = medium;
            } else {
                left = medium +1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args){
        int[] test_case_1 = {3,4,5,1,2};
        int[] test_case_2 = {11,13,15,17};
        Q153 fM = new Q153();
        System.out.println("case1: "+ fM.findMin(test_case_1));
        System.out.println("case2: "+ fM.findMin(test_case_2));
    }
}
