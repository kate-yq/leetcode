import java.util.ArrayList;
import java.util.HashSet;

class ArrayReduction{
    ArrayList<Integer> result;

    public int[] maxReducedArray(int[] arr){
        this.result = new ArrayList<>();
        reduce(arr, 0);
        int[] ans = new int[this.result.size()];
        for (int i=0; i<ans.length; i++){
            ans[i] = result.get(i);
        }
        return ans;
    }

    private void reduce(int[] arr, int start){
        if (start >= arr.length){
            return;
        }
        int mex = 0;
        int endIn = 0;
        HashSet<Integer> nums = new HashSet<>();
        for (int i=start; i<arr.length; i++){
            nums.add(arr[i]);
            while(nums.contains(mex)){
                mex++;
                endIn = i;
            }
        }
        this.result.add(mex);
        reduce(arr, endIn+1);
    }

    public static void main(String[] args){
        int[] arr = new int[]{0,1,1,0};
        ArrayReduction ar = new ArrayReduction();
        for (int i : ar.maxReducedArray(arr)){
            System.out.println(i);
        }
    }
}