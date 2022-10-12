import java.util.HashMap;

class Q211 {
    TrieNode root;

    public Q211() {
        this.root = new TrieNode();
        this.root.val = 0;
        this.root.next = new HashMap<>();
    }

    private class TrieNode {
        int val;
        HashMap<Character,TrieNode> next;
    }

    public void addWord(String word) {
        int i = 0;
        TrieNode cur = this.root;
        while (i < word.length()) {
            if (!cur.next.containsKey(word.charAt(i))){
                TrieNode temp = new TrieNode();
                temp.val = 0;
                temp.next = new HashMap<>();
                cur.next.put(word.charAt(i), temp);
            }
            cur = cur.next.get(word.charAt(i));
            i++;
        }
        cur.val = 1;
    }
    
    public boolean search(String word) {
        return _search(word, 0, this.root);
    }

    private boolean _search(String word, int i, TrieNode cur){
        if (i >= word.length()){
            if (cur.val == 1) {
                return true;
            } else {
                return false;
            }
        }
        if (word.charAt(i) == '.') {
            boolean result = false;
            for (Character c : cur.next.keySet()){
                result = result || _search(word, i+1, cur.next.get(c));
                if (result){
                    return result;
                }
            }
            return result;
        } else if (cur.next.containsKey(word.charAt(i))) {
            return _search(word, i+1, cur.next.get(word.charAt(i)));
        } else {
            return false;
        }
    }
}