public class Q2048 {
    int[] digits = {0,1,2,3,4,5,6,7,8,9};

    public int nextBeautifulNumber(int n) {
        int count = 0;
        int copy = n;
        while (copy>0){
            count++;
            copy = copy/10;
        }

        int a = dfs(n, 0, count);
        int b = dfs(0, 0, count+1);
        return a>0? a:b;
    }

    private int dfs(int min, int curval, int count){
        if (count == 0){
            // if has some number but not used up
            for (int i = 1; i <= 9; i++){
                if (digits[i] != i && digits[i] != 0)
                return 0;
            }
            return curval>min? curval:0;
        }
        int res = 0;
        for (int i = 1; res == 0 && i <= 9; i++){
            // if a number could use and if used up, not exceed count
            if (digits[i] > 0 && digits[i] <= count) {
                // use it
                digits[i]--;
                // recursive
                res = dfs(min, curval * 10 + i, count - 1);
                // add back
                digits[i]++;
            }
        }
        return res;
    }
}
