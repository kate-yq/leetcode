import java.util.*;

public class Q496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        HashMap<Integer, Integer> indexs = new HashMap<>();
        for (int i=0; i<nums2.length; i++){
            indexs.put(nums2[i], i);
        }

        int[] nextGreater = new int[nums2.length];
        Stack<Integer> monostack = new Stack<>();
        for (int i=nums2.length-1; i>=0; i--){
            while(!monostack.isEmpty() && nums2[i] >= monostack.peek()){
                monostack.pop();
            }
            if (monostack.isEmpty()){
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = monostack.peek();
            }
            monostack.push(nums2[i]);
        }

        for (int i=0; i<nums1.length; i++){
            ans[i] = nextGreater[indexs.get(nums1[i])];
        }

        return ans;
    }
}
