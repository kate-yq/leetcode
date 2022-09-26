import java.util.Arrays;

public class Q31 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int fix_current = nums.length - 1;
        int count = 1;
        // find the amount of desending elements at the right side
        // mark the first element break the desending
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] >= nums[i]) {
                count++;
            } else {
                fix_current = i - 1;
                break;
            }
        }
        if (count == 1) {
            int temp = nums[nums.length - 1];
            nums[nums.length - 1] = nums[nums.length - 2];
            nums[nums.length - 2] = temp;
            return;
        } else if (count == nums.length) {
            Arrays.sort(nums);
            return;
        } else {
            // find the min value that is larger than fix_right
            int fix_next = 0;
            for (int j = fix_current + 1; j < nums.length - 1; j++) {
                if (nums[j + 1] <= nums[fix_current]) {
                    fix_next = j;
                    int temp = nums[fix_current];
                    nums[fix_current] = nums[fix_next];
                    nums[fix_next] = temp;
                    break;
                } else if (j + 1 == nums.length - 1) {
                    fix_next = j + 1;
                    int temp = nums[fix_current];
                    nums[fix_current] = nums[fix_next];
                    nums[fix_next] = temp;
                    break;
                }
            }
            // swap the desending order to ascending
            int left = fix_current + 1;
            int right = nums.length - 1;
            while (right > left) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] test_case_1 = {1,3,4,2};
        int[] test_case_2 = {4,3,2,1};
        int[] test_case_3 = { 1, 5, 1 };
        Q31 nP = new Q31();
        System.out.println("test case 1:");
        nP.nextPermutation(test_case_1);
        for (int n:test_case_1){
        System.out.print(n+",");
        }
        System.out.println("test case 2:");
        nP.nextPermutation(test_case_2);
        for (int n:test_case_2){
        System.out.print(n+",");
        }
        System.out.println("test case 3:");
        nP.nextPermutation(test_case_3);
        for (int n : test_case_3) {
            System.out.print(n + ",");
        }
    }
}
