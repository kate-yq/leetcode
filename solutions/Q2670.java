import java.util.HashSet;

class Q2670 {
    public int[] distinctDifferenceArray(int[] nums) {
        int[] ans = new int[nums.length];

        HashSet<Integer> prefix = new HashSet<>();

        for (int i=0; i<nums.length; i++){
            prefix.add(nums[i]);
            ans[i] = prefix.size();
        }

        HashSet<Integer> suffix = new HashSet<>();

        for (int i=nums.length-1; i>=0; i--){
            ans[i] -= suffix.size();
            suffix.add(nums[i]);
        }

        return ans;
    }
}