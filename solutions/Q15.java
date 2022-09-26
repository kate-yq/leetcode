import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> sumList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (k > j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    sumList.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
            }
        }
        return sumList;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 };
        Q15 find3sum = new Q15();
        for (List<Integer> sumlist : find3sum.threeSum(nums)) {
            System.out.print("[ ");
            for (Integer sum : sumlist) {
                System.out.print(sum + " ");
            }
            System.out.println("]");
        }
    }
}