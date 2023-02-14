import java.util.HashSet;

public class Q219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++){
            if (set.contains(nums[i])){
                return true;
            } else {
                set.add(nums[i]);
            }
            if(i-k>=0){
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
