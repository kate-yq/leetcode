public class Q1804 {
    TrieNode root;

    private class TrieNode{
        int amount;
        TrieNode[] children;

        private TrieNode(){
            amount = 0;
            children = new TrieNode[26];
        }
    }

    public Q1804() {
        root = null;
    }
    
    public void insert(String word) {
        if (root == null){
            root = new TrieNode();
        }

        TrieNode itr = root;
        for (int i=0; i<word.length(); i++){
            int next = word.charAt(i) - 'a';

            if (itr.children[next] == null){
                itr.children[next] = new TrieNode();
            }
            itr = itr.children[next];
        }

        itr.amount++;
    }
    
    public int countWordsEqualTo(String word) {
        if (root == null){
            return 0;
        }
        TrieNode itr = root;
        for (int i=0; i<word.length(); i++){
            int next = word.charAt(i) - 'a';

            if (itr.children[next] == null){
                return 0;
            }
            itr = itr.children[next];
        }

        return itr.amount;
    }
    
    public int countWordsStartingWith(String prefix) {
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

        int sum = cur.amount;

        for (int i=0; i<26; i++){
            sum += traverse(cur.children[i]);
        }

        return sum;
    }
    
    public void erase(String word) {
        root = _erase(root, word, 0);
    }

    private TrieNode _erase(TrieNode cur, String key, int index){
        if (cur == null){
            return null;
        }
        if (index == key.length()){
            cur.amount--;
        } else {
            int next = key.charAt(index) - 'a';
            cur.children[next] = _erase(cur.children[next], key, index+1);
        }

        if (cur.amount != 0){
            return cur;
        } else {
            for (int i=0; i<26; i++){
                if (cur.children[i] != null){
                    return cur;
                }
            }
        }
        return null;
    }
}
