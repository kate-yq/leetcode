import java.util.HashMap;

public class Q2593 {
    public int findSmallestInteger(int[] nums, int value) {
        HashMap<Integer, Integer> remain = new HashMap<>();
        for (int num:nums){
            int r = (num % value) < 0? num%value+value : num%value;
            if (! remain.containsKey(r)){
                remain.put(r, 0);
            }
            remain.put(r, remain.get(r)+1);
        }
        int min = Integer.MAX_VALUE;
        int min_num = 0;
        int count = 0;
        while(count < value){
            if (remain.containsKey(count)){
                if (remain.get(count) < min){
                    min = remain.get(count);
                    min_num = count;
                }
            } else {
                return count;
            }
            count++;
        }
        return value * min + min_num; 
    }
}
