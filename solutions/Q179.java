import java.util.Arrays;

public class Q179 {
    public String largestNumber(int[] nums) {
        String[] numstoStrings = new String[nums.length];
        int sum = 0;
        for (int i=0; i<nums.length; i++){
            numstoStrings[i] = Integer.toString(nums[i]);
            sum = sum + nums[i];
        }
        if (sum == 0){
            return "0";
        }
        Arrays.sort(numstoStrings, (String a, String b)->{
            String a_front = a + b;
            String b_front = b + a;
            return b_front.compareTo(a_front);
        });
        StringBuilder combine = new StringBuilder();
        for (int i=0; i<numstoStrings.length; i++){
            combine.append(numstoStrings[i]);
        }
        return combine.toString();
    }
}
