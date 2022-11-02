import java.util.Arrays;
import java.util.HashMap;

class Q823 {
    public int numFactoredBinaryTrees(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        // has to search from small to large, or the answer will be wrong
        Arrays.sort(arr);
        // a hashMap to store all possible root-value and the corresponding ways of
        // trees
        HashMap<Integer, Long> dp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // Initialize: add all no-leaf tree
            dp.put(arr[i], (long) 1);
        }
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int left = 0; left < i; left++) {
                if (arr[i] % arr[left] == 0 && dp.containsKey(arr[i] / arr[left])) {
                    dp.put(arr[i], (dp.get(arr[i]) + dp.get(arr[left]) * dp.get(arr[i] / arr[left])) % 1000000007);
                }
            }
            sum = (sum + dp.get(arr[i])) % 1000000007;
        }
        return (int) sum;
    }
}