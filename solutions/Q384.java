import java.util.Random;

public class Q384 {
    int[] nums;
    Random rand = new Random();

    public Q384(int[] nums) {
        this.nums = nums;
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] copy = nums.clone();
        int n = copy.length;

        for (int i = 0; i < n - 1; i++) {
            int idx = i + rand.nextInt(n - i);
            int temp = copy[i];
            copy[i] = copy[idx];
            copy[idx] = temp;
        }

        return copy;
    }
}
