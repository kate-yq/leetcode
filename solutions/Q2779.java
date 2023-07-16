public class Q2779 {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length;
        int[][] range = new int[n][2];
        for (int i = 0; i < n; i++) {
            range[i][0] = nums[i] - k;
            range[i][1] = nums[i] + k + 1;
        }

        int[] arr = new int[100000 * 4];
        for (int[] r : range) {
            arr[r[0] + 100000]++;
            arr[r[1] + 100000]--;
        }

        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
