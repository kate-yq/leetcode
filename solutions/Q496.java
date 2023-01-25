import java.util.Arrays;

public class Q496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        for (int i=0; i<nums1.length;i++){
            boolean found = false;
            for(int j=0; j<nums2.length;j++){
                if (nums2[j] == nums1[i]){
                    found = true;
                }
                if (found && nums2[j]>nums1[i]){
                    ans[i] = nums2[j];
                    break;
                }
            }
        }
        return ans;
    }
}
