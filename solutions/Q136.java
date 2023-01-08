// import java.util.HashSet;

public class Q136 {
    public int singleNumber(int[] nums) {
        // // time: O(n)
        // // space: O(n)
        // HashSet<Integer> set = new HashSet<>();
        // for (int num: nums){
        //     if (set.contains(num)){
        //         set.remove(num);
        //     } else {
        //         set.add(num);
        //     }
        // }
        // int ans = 0;
        // for (int num:set){
        //     ans = num;
        // }
        // return ans;

        // time: O(n)
        // space: O(1)
        int a = 0;
        for (int i : nums) {
        a = a ^ i; // xOR
        }
        return a;
    }
}
