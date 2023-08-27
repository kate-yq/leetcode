public class Q2834 {
    public long minimumPossibleSum(int n, int target) {
        long sum = 0;
        int count = 0;

        int i = 1;
        while (i <= (target / 2)) {
            sum += i;
            count++;
            i++;
            if (count == n) {
                break;
            }
        }

        i = target;
        while (count < n) {
            count++;
            sum += i;
            i++;
        }

        return sum;
    }
}
