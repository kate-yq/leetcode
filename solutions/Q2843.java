public class Q2843 {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            count += calculate(i);
        }

        return count;
    }

    private int calculate(int num) {
        int digit = 1;

        while (Math.pow(10, digit) <= num) {
            digit++;
        }

        if (digit % 2 != 0) {
            return 0;
        }

        int before = 0;
        int after = 0;
        for (int i = 0; i < digit / 2; i++) {
            after += (num % 10);
            num /= 10;
        }
        for (int i = 0; i < digit / 2; i++) {
            before += (num % 10);
            num /= 10;
        }
        return before == after ? 1 : 0;
    }
}
