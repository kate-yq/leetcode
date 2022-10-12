public class Q208 {
    TrieNode root;
    int R = 26;

    public Q208() {
        this.root = new TrieNode();
        this.root.val = 0;
        this.root.next = new TrieNode[R];
    }

    private class TrieNode {
        int val;
        TrieNode[] next;
    }

    public void insert(String word) {
        int i = 0;
        TrieNode cur = this.root;
        while (i < word.length()) {
            if (cur.next[Integer.valueOf(word.charAt(i))-97] == null){
                TrieNode temp = new TrieNode();
                temp.val = 0;
                temp.next = new TrieNode[R];
                cur.next[Integer.valueOf(word.charAt(i))-97] = temp;
            }
            cur = cur.next[Integer.valueOf(word.charAt(i))-97];
            i++;
        }
        cur.val = 1;
    }

    public boolean search(String word) {
        int i = 0;
        TrieNode cur = this.root;
        while (i < word.length()) {
            if (cur.next[Integer.valueOf(word.charAt(i))-97] != null) {
                cur = cur.next[Integer.valueOf(word.charAt(i))-97];
                i++;
            } else {
                return false;
            }
        }
        if (cur.val == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        int i = 0;
        TrieNode cur = this.root;
        while (i < prefix.length()) {
            if (cur.next[Integer.valueOf(prefix.charAt(i))-97] != null) {
                cur = cur.next[Integer.valueOf(prefix.charAt(i))-97];
                i++;
            } else {
                return false;
            }
        }
        return true;
    }
}
