class Q9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int copx = x;
        int reverse = 0;
        while (copx > 0) {
            reverse = reverse * 10 + copx % 10;
            copx = copx / 10;
        }
        if (reverse == x) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int x = Integer.valueOf(args[0]);
        Q9 isP = new Q9();
        System.out.printf("the integer %d is Palindrome: ", x);
        System.out.println(isP.isPalindrome(x));
    }
}