import java.util.*;

public class Solution4 {
    // brute force : O(n!)-time complexity

    // use Hahsmap to record nums2 index and value
    // sort num1 and num2
    // from largest to smallest
    // if (num1[i] > nums2[i]){
    //     count as 1 pair => adv++;
    // } else {
    //     go compare the smaller element in nums2
    //     => index in nums2 will decrease
    //     until I find a pair 
    // }

    // [3, 5, 7] nums1
    // [1, 4, 9] nums2

    // ans [5,7,3]

    // basic logic is to pair the greatest element in nums2
    // which is smaller than the cur element in nums1

    // after I find a pair,
    // use the hash map to assess the index in nums2
    // fill the element in the corrending index in ans

    public int[] advantageCount(int[] nums1, int[] nums2) {
        // know index of nums2
        HashMap<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i=0; i<nums2.length; i++){
            if (!indexMap.containsKey(nums2[i])){
                indexMap.put(nums2[i], new ArrayList<>());
            }
            indexMap.get(nums2[i]).add(i);
        }

        // from smallest to largest
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // initialse the ans
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);

        int point1 = nums1.length-1;
        int point2 = nums2.length-1;
        while(point2 >= 0){ // mark
            while (point2>=0 && nums1[point1]<=nums2[point2]){
                point2--;
            }
            // found a pair || point2<0
            if (point2>=0){
                int index = indexMap.get(nums2[point2]).get(0);
                ans[index] = nums1[point1];
                indexMap.get(nums2[point2]).remove(0);
                point1--;
                point2--;
            } else {
                break;
            }
        }

        // fill the remaining spots
        int re = 0;
        while(point1>=0 && re<ans.length){
            if (ans[re]==-1){
                ans[re] = nums1[point1];
                point1--;
            }
            re++;
        }
        // return ans
        return ans;
    }
}
