import java.util.HashMap;

public class Q791 {
    public String customSortString(String order, String s) {
        StringBuilder afterSort = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i=0; i<order.length(); i++){
            map.put(order.charAt(i),i);
        }

        afterSort.append(s.charAt(0));
        for (int i=1; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                for (int j=0; j<=afterSort.length(); j++){
                    if (j==afterSort.length() || !map.containsKey(afterSort.charAt(j)) || map.get(s.charAt(i))<=map.get(afterSort.charAt(j))){
                        afterSort.insert(j, s.charAt(i));
                        break;
                    }
                }
            } else {
                afterSort.append(s.charAt(i));
            }
        }
        return afterSort.toString();
    }
}
