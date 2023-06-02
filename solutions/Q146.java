import java.util.*;

class LRUCache {
    LinkedHashMap<Integer, Integer> lru;
    int cap;

    public LRUCache(int capacity) {
        this.lru = new LinkedHashMap<>();
        this.cap = capacity;
    }
    
    public int get(int key) {
        if (!lru.containsKey(key)){
            return -1;
        }
        makeRecent(key);
        return lru.get(key);
    }
    
    public void put(int key, int value) {
        if (lru.containsKey(key)){
            lru.put(key, value);
            makeRecent(key);
            return;
        }
        if (lru.size() >= cap){
            int leastKey = lru.keySet().iterator().next();
            lru.remove(leastKey);
        }
        lru.put(key, value);
    }

    private void makeRecent(int key){
        int val = lru.get(key);
        lru.remove(key);
        lru.put(key, val);
    }
}