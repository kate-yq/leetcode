public class Q509 {
    public int fib(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        int[] fibo = new int[n+1];
        fibo[1] = 1;
        fibo[2] = 1;
        for (int i=3; i<=n; i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
        return fibo[n];
    }
}
