import java.util.*;

public class Q1696 {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] score = new int[n];
        score[0] = nums[0];

        // deque to record index
        // pop all index < i-k and all left index have elements smaller than max
        Deque<Integer> dq = new LinkedList<>();
        dq.offerLast(0);
        for (int i = 1; i < n; i++) {
            // pop the old index
            while (dq.peekFirst() != null && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }
            score[i] = score[dq.peekFirst()] + nums[i];
            // pop the smaller value
            while (dq.peekLast() != null && score[i] >= score[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return score[n - 1];
    }

    // cannot use recursion -- TLE

    // Integer[] scores;
    // int[] nums;

    // public int maxResult(int[] nums, int k) {
    //     this.scores = new Integer[nums.length];
    //     scores[nums.length-1] = nums[nums.length-1];
    //     this.nums = nums;
    //     dp(0, k);
    //     return scores[0];
    // }

    // private void dp(int start, int k){
    //     if (scores[start]!= null){
    //         return;
    //     }
    //     scores[start] = Integer.MIN_VALUE;
    //     for (int i=start+1; i<=start+k && i<nums.length; i++){
    //         if (scores[i]==null){
    //             dp(i,k);
    //         }
    //         scores[start] = Math.max(scores[start], scores[i]+nums[start]);
    //     }
    // }
}
