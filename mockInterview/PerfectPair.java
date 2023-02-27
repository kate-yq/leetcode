import java.util.Arrays;

public class PerfectPair {
    public int numPerfectPair(int[] nums){
        // statement 2 always holds
        // statement 1 is |y|<= 2|x| when |x|<=|y|
        // so sort the absolute value then use 2 pointers
        int n = nums.length;

        int[] abs = new int[n];
        for (int i=0; i<n; i++){
            abs[i] = Math.abs(nums[i]);
        }
        Arrays.sort(abs);
        int sum = 0;

        int left = 0;
        int right = 1;
        while (left < n-1 && right < n){
            if (abs[right]<=abs[left]*2){
                sum += (right-left);
                right++;
            } else {
                left++;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        int[] test= {-9, 6, 2, -1};
        PerfectPair pp = new PerfectPair();
        System.out.println(pp.numPerfectPair(test));
    }
}
