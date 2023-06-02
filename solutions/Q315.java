import java.util.*;

public class Q315 {

    private class Pair{
        int val;
        int id;

        Pair(int val, int id){
            this.val = val;
            this.id = id;
        }
    }


    int[] count;
    Pair[] temp;

    public List<Integer> countSmaller(int[] nums) {
        this.count = new int[nums.length];
        this.temp = new Pair[nums.length];

        Pair[] arr = new Pair[nums.length];

        for (int i=0; i<nums.length; i++){
            arr[i] = new Pair(nums[i], i);
        }

        sort(arr, 0, nums.length-1);
        
        List<Integer> ans = new ArrayList<>();
        for (int c : count){
            ans.add(c);
        }

        return ans;
    }

    private void sort(Pair[] arr, int lo, int hi){
        if (lo == hi){
            return;
        }

        int mid = lo + (hi-lo)/2;

        sort(arr, lo, mid);
        sort(arr, mid+1, hi);

        merge(arr, lo, mid, hi);
    }

    private void merge(Pair[] arr, int lo, int mid, int hi){
        for (int i=lo; i<=hi; i++){
            temp[i] = arr[i];
        }

        int i = lo;
        int j = mid+1;

        for (int p=lo; p<=hi; p++){
            if (i>mid){
                arr[p] = temp[j];
                j++;
            } else if (j>hi){
                arr[p] = temp[i];
                i++;
                count[arr[p].id] += (j - mid -1);
            } else if (temp[i].val > temp[j].val){
                arr[p] = temp[j];
                j++;
            } else {
                arr[p] = temp[i];
                i++;
                count[arr[p].id] += (j - mid -1);
            }
        }
    }
}
