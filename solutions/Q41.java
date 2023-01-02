public class Q41 {
    public int firstMissingPositive(int[] nums) {
        // step 1: check if there is 1 in the array
        // if not, return 1;

        // step 2: change all numbers >n, <=0 to 1
        boolean found1 = false;
        for (int i=0; i<nums.length; i++){
            if (nums[i] == 1){
                found1 =true;
            }
            if (nums[i]<=0 || nums[i]>nums.length){
                nums[i] = 1;
            }
        }
        if (!found1){
            return 1;
        }
        // step 3: go through array
        // change the [x] to negative to mark the find

        for (int i=0; i<nums.length; i++){
            if(nums[Math.abs(nums[i])%nums.length]>0){
                nums[Math.abs(nums[i])%nums.length] = -nums[Math.abs(nums[i])%nums.length];
            }
        }

        // loop throught to find the first positive element
        // the index is the missing number
        // if there is not, return n+1

        for (int i=1; i<= nums.length; i++){
            if (nums[i%nums.length]>0){
                return i;
            }
        }
        return nums.length+1;
    }
}
