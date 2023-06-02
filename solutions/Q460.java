import java.util.*;

public class Q460 {
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKey;
    int minFreq;
    int cap;

    public Q460(int capacity) {
        this.keyToFreq = new HashMap<>();
        this.keyToVal = new HashMap<>();
        this.freqToKey = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)){
            return -1;
        }

        increaseFreq(key);
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if (keyToVal.containsKey(key)){
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }
        if (keyToVal.size() == cap){
            removeMinFreq();
            // no need to update minFreq
            // because will update minFreq right below
        }
        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKey.putIfAbsent(1, new LinkedHashSet<>());
        freqToKey.get(1).add(key);
        minFreq = 1;
    }

    private void increaseFreq(int key){
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq+1);
        freqToKey.putIfAbsent(freq+1, new LinkedHashSet<>());
        freqToKey.get(freq+1).add(key);
        freqToKey.get(freq).remove(key);
        if (freqToKey.get(freq).size() == 0){
            freqToKey.remove(freq);
            if (minFreq == freq){
                minFreq++;
            }
        }
    }

    private void removeMinFreq(){
        int keyToRemove = freqToKey.get(minFreq).iterator().next();
        keyToFreq.remove(keyToRemove);
        keyToVal.remove(keyToRemove);
        freqToKey.get(minFreq).remove(keyToRemove);
        if (freqToKey.get(minFreq).isEmpty()){
            freqToKey.remove(minFreq);
        }
    }
}
