import java.util.*;

public class Q503 {
    public int[] nextGreaterElements(int[] nums) {
        // using a stack and iterate from the end of the array

        int[] ans = new int[nums.length];
        Stack<Integer> indexs = new Stack<>();

        for (int count=0; count<2; count++){
            for (int i=nums.length-1; i>=0; i--){
                while (!indexs.isEmpty() && nums[indexs.peek()]<=nums[i]){
                    indexs.pop();
                }
                if (indexs.isEmpty()){
                    ans[i] = -1;
                } else {
                    ans[i] = nums[indexs.peek()];
                }
                indexs.push(i);
            }
        }
        return ans;


        // int n = nums.length;
        // PriorityQueue<Integer> maxheap = new PriorityQueue<>(
        //     (a,b) -> b-a
        // );
        // HashMap<Integer, ArrayList<Integer>> indexs = new HashMap<>();

        // for (int i =0; i<n; i++){
        //     if (!indexs.containsKey(nums[i])){
        //         indexs.put(nums[i], new ArrayList<>());
        //         maxheap.add(nums[i]);
        //     }
        //     indexs.get(nums[i]).add(i);
        // }

        // int[] ans = new int[n];
        // boolean[] checked = new boolean[n];

        // ArrayList<Integer> max = indexs.get(maxheap.poll());
        // for (int i : max){
        //     ans[i] = -1;
        //     checked[i] = true;
        // }
        // while (!maxheap.isEmpty()){
        //     ArrayList<Integer> cur = indexs.get(maxheap.poll());
        //     for (int i : cur){
        //         for (int j = 0; j<n; j++){
        //             if (checked[(i+j)%n] && nums[(i+j)%n]>nums[i]){
        //                 ans[i] = nums[(i+j)%n];
        //                 checked[i] = true;
        //                 break;
        //             }
        //         }
        //     }
        // }
        // return ans;
    }
}
