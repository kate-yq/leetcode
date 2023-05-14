import java.util.*;

public class Q710 {
    int size;
    HashMap<Integer, Integer> mapping;

    public Q710(int n, int[] blacklist) {
        mapping = new HashMap<>();
        size = n - blacklist.length;

        for (int b : blacklist){
            mapping.put(b, -1);
        }

        int last = n-1;

        for (int b : blacklist){
            if (b < size){
                while (mapping.containsKey(last)){
                    last--;
                }
                mapping.put(b, last);
                last--;
            }
        }
    }
    
    public int pick() {
        int index = (int) (Math.random() * size);

        if (mapping.containsKey(index)){
            return mapping.get(index);
        }

        return index;
    }
}
