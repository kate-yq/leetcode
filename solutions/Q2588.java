import java.util.HashMap;

public class Q2588 {
    public long beautifulSubarrays(int[] nums) {
        int n = nums.length;
        
        int[] prefixXor= new int[n+1];
        prefixXor[0] = 0;
        for (int i=1; i<=n; i++){
            prefixXor[i] = nums[i-1] ^ prefixXor[i-1];
        }
        
        long count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i<=n; i++){
            if (map.containsKey(prefixXor[i])){
                count += map.get(prefixXor[i]);
                map.put(prefixXor[i], map.get(prefixXor[i])+1);    
            } else {
                map.put(prefixXor[i], 1);
            }
        }
        return count;
    }
}
