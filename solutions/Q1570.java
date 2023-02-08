import java.util.HashMap;

public class Q1570 {
    HashMap<Integer, Integer> map;

    Q1570(int[] nums) {
        this.map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            if (nums[i]!=0){
                map.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(Q1570 vec) {
        int ans = 0;
        for(int key : this.map.keySet()){
            if (vec.map.keySet().contains(key)){
                ans += this.map.get(key)*vec.map.get(key);
            }
        }
        return ans;
    }
}
