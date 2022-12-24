import java.util.HashMap;

class Q525 {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> bal_index = new HashMap<>();
        int balance = 0;
        int result = 0;
        // mark the index when there is no elements at all
        bal_index.put(0, -1);
        for (int i=0; i<nums.length; i++){
            if (nums[i]==0){
                balance--;
            } else {
                balance++;
            }
            if (bal_index.containsKey(balance)){
                result = Math.max(result, i-bal_index.get(balance));
            } else {
                bal_index.put(balance, i);
            }
        }
        return result;
    }
}