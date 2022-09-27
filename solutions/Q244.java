import java.util.ArrayList;
import java.util.HashMap;

public class Q244 {
    HashMap<String, ArrayList<Integer>> dict = new HashMap<>();
    public Q244(String[] wordsDict) {
        for (int i=0; i<wordsDict.length; i++){
            if (this.dict.containsKey(wordsDict[i])){
                this.dict.get(wordsDict[i]).add(i);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                this.dict.put(wordsDict[i], temp);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        int distance = Integer.MAX_VALUE;
        int loc_1 = 0;
        int loc_2 = 0;
        while(loc_1<this.dict.get(word1).size() && loc_2<this.dict.get(word2).size()){
            distance = Math.min(distance, Math.abs(this.dict.get(word1).get(loc_1)-this.dict.get(word2).get(loc_2)));
            if (this.dict.get(word1).get(loc_1)>this.dict.get(word2).get(loc_2)){
                loc_2++;
            } else {
                loc_1++;
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        String[] test_case = {"practice", "makes", "perfect", "coding", "makes"};
        Q244 wD = new Q244(test_case);
        System.out.println(wD.shortest("coding", "makes"));
    }
}
