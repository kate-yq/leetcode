import java.util.*;

public class TrieMap<E> {
    static final int R = 256;
    TrieNode<E> root;
    int size;

    private static class TrieNode<V> {
        V val;
        TrieNode<V>[] children = new TrieNode[R];
    }

    public TrieMap(){
        this.root = null;
        this.size = 0;
    }

    public void put(String key, E val){
        if (!containsKey(key)){
            size++;
        }
        root = _put(root, key, 0, val);
    }

    private TrieNode<E> _put(TrieNode<E> cur, String key, int index, E val){
        if (cur == null){
            cur = new TrieNode<>();
        }
        if (index == key.length()){
            cur.val = val;
            return cur;
        }
        char c = key.charAt(index);
        cur.children[c] = _put(cur.children[c], key, index+1, val);
        return cur;
    }

    private TrieNode<E> getNode(TrieNode<E> node, String key){
        TrieNode<E> p = node;
        for (int i=0; i<key.length(); i++){
            if (p == null){
                return null;
            }

            char c = key.charAt(i);
            p = p.children[c];
        }
        return p;
    }

    public E get(String key){
        TrieNode<E> p = getNode(root, key);
        return p == null? null : p.val;
    }

    public boolean containsKey(String key){
        TrieNode<E> p = getNode(root, key);
        return p != null && p.val != null;
    }

    public boolean containsPrefix(String prefix){
        return getNode(root, prefix) != null;
    }

    public String shortestPrefixOf(String key){
        TrieNode<E> p = root;

        for (int i=0; i<key.length(); i++){
            if (p == null){
                return "";
            }
            if (p.val != null){
                return key.substring(0, i);
            }

            char c = key.charAt(i);
            p = p.children[c];
        }

        if (p != null && p.val != null){
            return key;
        }

        return "";
    }

    public String longestPrefixOf(String key){
        TrieNode<E> p = root;
        int maxlen = 0;

        for (int i=0; i<key.length(); i++){
            if (p == null){
                return "";
            }
            if (p.val != null){
                maxlen = i;
            }

            char c = key.charAt(i);
            p = p.children[c];
        }

        if (p.val != null && p.val != null){
            return key;
        }

        return key.substring(0, maxlen);
    }

    public List<String> keysWithPrefix(String prefix){
        List<String> ans = new ArrayList<>();
        TrieNode<E> start = getNode(root, prefix);
        StringBuilder sb = new StringBuilder(prefix);

        traverse(start, sb, ans);

        return ans;
    }

    private void traverse(TrieNode<E> cur, StringBuilder sb, List<String> ans){
        if (cur == null){
            return;
        }

        if (cur.val != null){
            ans.add(sb.toString());
        }

        for (char c=0; c<R; c++){
            sb.append(c);
            traverse(cur.children[c], sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> keysWithPattern(String pattern){
        List<String> ans = new ArrayList<>();
        traverse(root, new StringBuilder(), pattern, 0, ans);
        return ans;
    }

    private void traverse(TrieNode<E> cur, StringBuilder sb, String pattern, int index, List<String> ans){
        if (cur == null){
            return;
        }
        if (index == pattern.length()){
            if (cur.val != null){
                ans.add(sb.toString());
            }
            return;
        }
        char c = pattern.charAt(index);
        if (c == '.'){
            for (char next = 0; next<R; next++){
                sb.append(next);
                traverse(cur.children[next], sb, pattern, index+1, ans);
                sb.deleteCharAt(sb.length()-1);
            }
        } else {
            sb.append(c);
            traverse(cur.children[c], sb, pattern, index+1, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public boolean hasKeyWithPattern(String pattern){
        return _hasKeyWithPattern(root, pattern, 0);
    }

    private boolean _hasKeyWithPattern(TrieNode<E> cur, String pattern, int index){
        if (cur == null){
            return false;
        }
        if (index == pattern.length()){
            return cur.val != null;
        }
        char c = pattern.charAt(index);
        if (c == '.'){
            for (char next = 0; next<R; next++){
                if (_hasKeyWithPattern(cur.children[next],pattern, index+1)){
                    return true;
                }
            }
        } else {
            return _hasKeyWithPattern(cur.children[c],pattern, index+1);
        }

        return false;
    }

    public void remove(String key){
        if (containsKey(key)){
            size--;
            root = _remove(root, key, 0);
        }
    }

    private TrieNode<E> _remove(TrieNode<E> cur, String key, int index){
        if (cur == null){
            return null;
        }
        if (index == key.length()){
            cur.val = null;
        } else {
            char c = key.charAt(index);
            cur.children[c] = _remove(cur.children[c], key, index+1);
        }

        if (cur.val != null){
            return cur;
        } else {
            for (char c=0; c<R; c++){
                if (cur.children[c] != null){
                    return cur;
                }
            }
        }

        return null;
    }
}
