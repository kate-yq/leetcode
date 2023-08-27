import java.util.*;

public class Q2835 {
    public static int minOperations(List<Integer> nums, int target) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target) {
            return -1;
        }

        // HashMap<Integer, Integer> freq = new HashMap<>();
        // for (int num : nums) {
        // freq.put(num, freq.getOrDefault(num, 0) + 1);
        // }

        int[] count = new int[31];

        for (int num : nums) {
            int log = (int) (Math.log(num) / Math.log(2));
            count[log]++;
        }

        int[] toBinary = new int[31];
        int index = 0;
        while (target > 0) {
            toBinary[index] = target % 2;
            target /= 2;
            index++;
        }

        int op = 0;
        for (int i = 0; i < 31; i++) {
            if (count[i] >= toBinary[i]) {
                count[i] -= toBinary[i];
                if (i < 30) {
                    count[i + 1] += (count[i] / 2);
                    count[i] %= 2;
                }
            } else {
                int j = i + 1;
                while (j < 31 && count[j] == 0) {
                    j++;
                }
                if (j == 31) {
                    return -1;
                }
                while (j > i) {
                    count[j]--;
                    count[j - 1] += 2;
                    op++;
                    j--;
                }
                count[i] -= toBinary[i];
            }
        }

        return op;
    }

    public static void main(String[] args) {
        List<Integer> test = Arrays.asList(
                64, 1, 16384, 16384, 1024, 1, 2, 4096, 2, 2,
                65536, 1, 65536, 4, 4, 256, 4, 16384, 16384,
                8388608, 16384, 4, 2, 4096, 4, 1073741824,
                16777216, 4, 2, 256, 1, 4, 256, 16384, 1073741824,
                4096, 1, 4096, 4, 16384, 4, 4);
        System.out.println(minOperations(test, 42));
    }
}
