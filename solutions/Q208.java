public class Q208 {
    TrieNode root;

    private static class TrieNode{
        boolean val;
        TrieNode[] children;

        private TrieNode(){
            this.val = false;
            this.children = new TrieNode[26];
        }
    }

    public Q208() {
        this.root = null;
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
        itr.val = true;
    }
    
    public boolean search(String word) {
        if (root == null){
            return false;
        }

        TrieNode itr = root;
        for (int i=0; i<word.length(); i++){
            int next = word.charAt(i) -'a';
            if (itr.children[next] == null){
                return false;
            }
            itr = itr.children[next];
        }

        return itr.val;
    }
    
    public boolean startsWith(String prefix) {
        if (root == null){
            return false;
        }

        TrieNode itr = root;
        for (int i=0; i<prefix.length(); i++){
            int next = prefix.charAt(i) -'a';
            if (itr.children[next] == null){
                return false;
            }
            itr = itr.children[next];
        }

        return true;
    }
}
