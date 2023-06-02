import java.util.*;

public class Q503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Stack<Integer> monostack = new Stack<>();
        for (int i=2*n-1; i>=0; i--){
            while (!monostack.isEmpty() && monostack.peek()<=nums[i % n]){
                monostack.pop();
            }
            if (monostack.isEmpty()){
                ans[i % n] = -1;
            } else {
                ans[i % n] = monostack.peek();
            }
            monostack.push(nums[i % n]);
        }

        return ans;
    }
}
