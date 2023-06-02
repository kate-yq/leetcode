class Q211 {
    TrieNode root;

    private static class TrieNode{
        boolean val;
        TrieNode[] children;

        private TrieNode(){
            this.val = false;
            this.children = new TrieNode[26];
        }
    }
    
    public Q211() {
        this.root = null;
    }
    
    public void addWord(String word) {
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
        return _search(root, word, 0);
    }

    private boolean _search(TrieNode cur, String word, int index){
        if (cur == null){
            return false;
        }
        if (index == word.length()){
            return cur.val;
        }

        if (word.charAt(index) == '.'){
            for (int i=0; i<26; i++){
                if (_search(cur.children[i], word, index+1)){
                    return true;
                }
            }
        } else {
            int next = word.charAt(index) - 'a';
            return _search(cur.children[next], word, index+1);
        }
        return false;
    }
}