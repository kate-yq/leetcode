import java.util.TreeSet;

public class Q2601 {
    public boolean primeSubOperation(int[] nums) {
        TreeSet<Integer> primes = new TreeSet<>();
        
        for (int i=2; i<1000; i++){
            boolean isPrime = true;
            for (int j=2; j<= Math.pow(i,0.5); j++){
                if (i%j == 0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime){
                primes.add(i);
            }
        }

        int n = nums.length;
        for (int i=0; i<n; i++){
            for (int p : primes.descendingSet()){
                if (p < nums[i] && (i==0 || nums[i]-p>nums[i-1])){
                    nums[i] -= p;
                    break;
                }
            }
        }

        for(int i=1; i<n; i++){
            if (nums[i]<= nums[i-1]){
                return false;
            }
        }
        return true;
    }
}
