import java.util.HashMap;

public class Q771 {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i=0; i<stones.length(); i++){
            if (!count.containsKey(stones.charAt(i))){
                count.put(stones.charAt(i), 1);
            } else {
                count.put(stones.charAt(i),count.get(stones.charAt(i))+1);
            }
        }

        int sum = 0;
        for (int i=0; i<jewels.length(); i++){
            if (count.containsKey(jewels.charAt(i))){
                sum += count.get(jewels.charAt(i));
            }
        }
        return sum;
    }
}
