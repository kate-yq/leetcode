import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Q692 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> results = new ArrayList<>();
        HashMap<String, Integer> freq = new HashMap<>();
        PriorityQueue<Pair<String, Integer>> max_heap = new PriorityQueue<>(
            (a, b) -> {
                if (b.getValue() == a.getValue()){
                    return a.getKey().compareTo(b.getKey());
                } else {
                    return b.getValue()-a.getValue();
                }
            });
        for (int i=0; i<words.length; i++){
            if (freq.containsKey(words[i])){
                freq.put(words[i], freq.get(words[i])+1);
            } else {
                freq.put(words[i], 1);
            }
        }
        for (String key : freq.keySet()){
            max_heap.add(new Pair<String,Integer>(key, freq.get(key)));
        }
        for (int i=0; i<k; i++){
            results.add(max_heap.poll().getKey());
        }
        return results;
    }
}
