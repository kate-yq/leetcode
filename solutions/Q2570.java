import java.util.*;

class Q2570{
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        ArrayList<int[]> result = new ArrayList<>();
        int pointer1 = 0;
        int pointer2 = 0;
        while(pointer1 < nums1.length && pointer2 < nums2.length){
            if (nums1[pointer1][0] < nums2[pointer2][0]){
                result.add(new int[]{nums1[pointer1][0], nums1[pointer1][1]});
                pointer1++;
            } else if (nums1[pointer1][0] > nums2[pointer2][0]){
                result.add(new int[]{nums2[pointer2][0], nums2[pointer2][1]});
                pointer2++;
            } else {
                result.add(new int[]{nums1[pointer1][0], nums1[pointer1][1]+nums2[pointer2][1]});
                pointer1++;
                pointer2++;
            }
        }

        while (pointer1 < nums1.length){
            result.add(new int[]{nums1[pointer1][0], nums1[pointer1][1]});
            pointer1++;
        }

        while (pointer2 < nums2.length){
            result.add(new int[]{nums2[pointer2][0], nums2[pointer2][1]});
            pointer2++;
        }
        int[][] results = new int[result.size()][2];
        for (int i=0; i<results.length; i++){
            results[i] = result.get(i);
        }
        return results;
    }
}