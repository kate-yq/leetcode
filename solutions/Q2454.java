import java.util.Arrays;
import java.util.LinkedList;

public class Q2454 {
    public int[] secondGreaterElement(int[] nums) {
        // use 2 linked list to record the index
        // s1 is the element that has not find their first larger
        // s2 is the element that found the first, but not the second
        // each element compare to the tail of s2 then remove all smaller
        // then compare to the tail of s1, add smaller to s2

        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        LinkedList<Integer> nofirst = new LinkedList<>();
        LinkedList<Integer> nosecond = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        for (int i=0; i<nums.length; i++){
            while (!nosecond.isEmpty() && nums[i]>nums[nosecond.getLast()]){
                ans[nosecond.removeLast()] = nums[i];
            }
            while (!nofirst.isEmpty() && nums[i]>nums[nofirst.getLast()]){
                temp.add(nofirst.removeLast());
            }
            while(!temp.isEmpty()){
                nosecond.add(temp.removeLast());
            }
            nofirst.add(i);
        }
        return ans;
    }
}
