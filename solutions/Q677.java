public class Q677 {
    TrieNode root;

    private static class TrieNode{
        int val;
        TrieNode[] children;

        private TrieNode(){
            this.val = 0;
            this.children = new TrieNode[26];
        }
    }

    public Q677() {
        this.root = null;
    }
    
    public void insert(String key, int val) {
        if (root == null){
            root = new TrieNode();
        }

        TrieNode itr = root;
        for (int i=0; i<key.length(); i++){
            int next = key.charAt(i) - 'a';
            if (itr.children[next] == null){
                itr.children[next] = new TrieNode();
            }
            itr = itr.children[next];
        }

        itr.val = val;
    }
    
    public int sum(String prefix) {
        if (root == null){
            return 0;
        }
        TrieNode itr = root;
        for (int i=0; i<prefix.length(); i++){
            int next = prefix.charAt(i) - 'a';
            if (itr.children[next] == null){
                return 0;
            }
            itr = itr.children[next];
        }
        return traverse(itr);
    }

    private int traverse(TrieNode cur){
        if (cur == null){
            return 0;
        }
        int sum = cur.val;
        for (int i=0; i<26; i++){
            sum += traverse(cur.children[i]);
        }

        return sum;
    }
}
