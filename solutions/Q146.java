import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        /**
         * Remove an existing node from the linked list.
         */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node) {
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        // head.prev = null;

        tail = new DLinkedNode();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null)
            return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if (size > capacity) {
                // pop the tail
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }


    // int capacity;
    // HashMap<Integer, Integer> mp;
    // ArrayList<Integer> que;

    // public LRUCache(int capacity) {
    // this.mp = new HashMap<>();
    // this.capacity = capacity;
    // // index 0 is LRU if not repeated, and last element is most recently used
    // this.que = new ArrayList<>();
    // }

    // public int get(int key) {
    // if (mp.containsKey(key)) {
    // if (mp.size() == 1) {
    // return this.mp.get(key);
    // }
    // this.que.add(key);
    // return this.mp.get(key);
    // } else {
    // // nothing need to change
    // return -1;
    // }
    // }

    // public void put(int key, int value) {
    // if (mp.containsKey(key)) {
    // // remove corresponding key form list and append to tail
    // // then update the mp directly
    // if (mp.size() == 1) {
    // this.mp.put(key, value);
    // return;
    // }
    // this.que.add(key);
    // this.mp.put(key, value);
    // return;
    // }
    // // if reach capacity, remove index0/lru and add new pair
    // if (this.mp.size() == this.capacity) {
    // int lru = this.que.get(0);
    // this.que.remove(0);
    // // if this lru is still contained, then get next one
    // while (this.que.contains(lru)){
    // lru = this.que.get(0);
    // this.que.remove(0);
    // }
    // this.mp.remove(lru);

    // this.mp.put(key, value);
    // this.que.add(key);
    // return;
    // }
    // // initiate the first key
    // if (this.mp.size() == 0) {
    // this.mp.put(key, value);
    // this.que.add(key);
    // return;
    // }
    // // not initiation, not reach capacity, not same key
    // this.mp.put(key, value);
    // this.que.add(key);
    // return;
    // }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(1);
        System.out.println(obj.get(6));
        System.out.println(obj.get(8));
        obj.put(12, 1);
        System.out.println(obj.get(2));
        obj.put(15, 11);
        obj.put(5, 2);
        obj.put(1, 15);
        obj.put(4, 2);
        System.out.println(obj.get(5));
        obj.put(15, 15);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */