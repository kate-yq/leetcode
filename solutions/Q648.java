import java.util.*;

public class Q648 {
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] words = sentence.split(" ");

        Trie triemap = new Trie();
        for (String d : dictionary){
            triemap.addWord(d);
        }

        StringBuilder ans = new StringBuilder();

        for (String word : words){
            ans.append(triemap.shortestPrefixOf(word));
            ans.append(" ");
        }

        ans.deleteCharAt(ans.length()-1);

        return ans.toString();
    }

    private class Trie{
        TrieNode root;

        private static class TrieNode{
            boolean val;
            TrieNode[] children = new TrieNode[26];
        }

        private void addWord(String word){
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

        private String shortestPrefixOf(String word){
            if (root == null){
                return word;
            }
            TrieNode itr = root;
            for (int i=0; i<word.length(); i++){
                if (itr == null){
                    return word;
                }
                if (itr.val){
                    return word.substring(0, i);
                }

                int next = word.charAt(i) - 'a';
                itr = itr.children[next];
            }

            return word;
        }
    }
}
