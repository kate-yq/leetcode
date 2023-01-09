public class Q319 {
    public int bulbSwitch(int n) {
        if (n == 0){
            return 0;
        }
        // each bulb will be toggled x times, where x is the amount of its unique factor
        // factors usually appears in pairs, like 1*n, 2*n/2 ...
        // but when the number is a squre of an int
        // its amount of factors is odd, like 25 = 5*5, 1*25, 5 will only count once
        // conclution: squre number will be toggled by odd times
        // 1st -- on, 2nd -- off, ..., 
        // odd -- on, even -- off
        int ans = 0;  // all off as started
        int i = 1;
        while (i*i<=n){
            ans++;
            i++; 
        }
        return ans;
    }
}
