public class Q2772 {
    public static boolean checkArray(int[] nums, int k) {
        // if (k == 1) {
        // return true;
        // }

        // int n = nums.length;
        // for (int i = 0; i < n - k + 1; i++) {
        // if (nums[i] > 0) {
        // int temp = nums[i];
        // for (int j = i; j < i + k; j++) {
        // if (nums[j] < temp) {
        // return false;
        // }
        // nums[j] -= temp;
        // }
        // }
        // }

        // for (int i = Math.max(n - k, 0); i < n; i++) {
        // if (nums[i] != 0) {
        // return false;
        // }
        // }
        // return true;

        int[] decrease = new int[nums.length];
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur > nums[i]) {
                return false;
            } else if (cur < nums[i]) {
                if (i + k > nums.length) {
                    return false;
                }
                decrease[i + k - 1] = nums[i] - cur;
                cur = nums[i];
            }
            cur -= decrease[i];
        }
        return true;
    }

    public static void main(String[] args) {
        int[] testcase = new int[] { 2, 2, 3, 1, 1, 0 };
        System.out.println(checkArray(testcase, 3));
    }
}
